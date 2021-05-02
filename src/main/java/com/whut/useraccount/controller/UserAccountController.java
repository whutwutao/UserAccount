package com.whut.useraccount.controller;


import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.whut.useraccount.bean.PageBean;
import com.whut.useraccount.bean.UserAccount;
import com.whut.useraccount.service.UserAccountService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/userAccount")
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    private UserAccount myUserAccount;

    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        UserAccount userAccount = new UserAccount();
        userAccount.setName(name);
        userAccount.setPassword(password);
        UserAccount userAccount1 = userAccountService.login(userAccount);
        if (userAccount1 != null) {
            model.addAttribute("userAccount",userAccount1);
            return "frame";
        } else {
            return "index";
        }

    }

    @RequestMapping(value = "/toRegister", method = RequestMethod.GET)
    public String toRegister() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        UserAccount userAccount = new UserAccount();
        userAccount.setName(name);
        userAccount.setPassword(password);
        int tag = -1;
        try {
            tag = userAccountService.insert(userAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (tag > 0) {
            return "index";
        } else {
            return "register";
        }

    }

    /**
     * 进入到主页面
     * @return
     */
    @RequestMapping(value = "/frame", method = RequestMethod.GET)
    public String mainFrame() {
        return "frame";
    }

    @RequestMapping(value = "/allUserAccountList/{pageNum}", method = RequestMethod.GET)
    public String allUserAccountList(@PathVariable("pageNum") Integer pageNum, Model model) {
        if (pageNum == null) {
            pageNum = 1;
        }
        int pageRecord = 8;
        try {
            PageBean<UserAccount> pb = userAccountService.allList((pageNum-1)*pageRecord,pageRecord);
            myUserAccount = new UserAccount();
            model.addAttribute("pb",pb);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() throws Exception {
        return "add";
    }

    @RequestMapping(value = "/addUserAccountSubmit", method = RequestMethod.GET)
    public String addUserAccountSuccess(UserAccount userAccount) {
        try {
            userAccountService.insert(userAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:allUserAccountList/1";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editUserAccount(@PathVariable("id") int id, Model model) {
        try {
            UserAccount userAccount = userAccountService.getById(id);
            model.addAttribute("userAccount",userAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "edit";
    }

    @RequestMapping(value = "/toChangePassword/{id}", method = RequestMethod.GET)
    public String toChangePassword(@PathVariable("id") int id, Model model) {
        UserAccount userAccount = null;
        try {
            userAccount = userAccountService.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("userAccount",userAccount);
        return "changePassword";
    }

    @RequestMapping(value = "/changPassword", method = RequestMethod.GET)
    public String changePassword(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        String newPassword = request.getParameter("newPassword");
        System.out.println(id);
        System.out.println(newPassword);
        userAccountService.changePassword(id,newPassword);
        return "redirect:/userAccount/toChangePassword/" + String.valueOf(id);
    }

    @RequestMapping(value = "/editUserAccountSubmit",method = RequestMethod.POST)
    public String editUserAccountSubmit(@Param("id") int id, @Param("userAccount") UserAccount userAccount) {
        try {
            userAccountService.update(id,userAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:allUserAccountList/1";
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public String queryList(){
        // 进入模糊查询页面
        return "query";
    }

    @RequestMapping(value = "/list/{pageNum}", method = {RequestMethod.GET, RequestMethod.POST})
    public String queryUserAccountList(@PathVariable("pageNum") Integer pageNum, UserAccount userAccount, Model model) {
        if (pageNum == null) {
            pageNum = 1;
        }
        int pageRecord = 8;
        if (userAccount != null) {
            myUserAccount = userAccount;
        }
        try {
            PageBean<UserAccount> pb = userAccountService.queryList((pageNum-1)*pageRecord, pageRecord, myUserAccount);
            model.addAttribute("pb",pb);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void deleteUserAccount(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
        try {
            userAccountService.delete(id);
            String url = request.getRequestURL().toString();
            String newUrl = url.substring(0,url.lastIndexOf("delete")) + "allUserAccountList/1";
            response.sendRedirect(newUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
