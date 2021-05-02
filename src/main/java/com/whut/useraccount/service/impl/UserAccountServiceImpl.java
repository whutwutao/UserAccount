package com.whut.useraccount.service.impl;

import com.whut.useraccount.bean.PageBean;
import com.whut.useraccount.bean.UserAccount;
import com.whut.useraccount.mapper.UserAccountMapper;
import com.whut.useraccount.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountMapper userAccountMapper;


    @Override
    public PageBean<UserAccount> allList(int offset, int pageRecord) throws Exception {
        List<UserAccount> userAccounts = userAccountMapper.findAll(offset,pageRecord);
        UserAccount userAccount = new UserAccount();
        int totalRecord = userAccountMapper.countUserAccount(userAccount);

        int pageNum = offset / pageRecord + 1;

        //计算总页数
        int totalPage;
        if (totalRecord % pageRecord == 0) {
            totalPage = totalRecord / pageRecord;
        } else {
            totalPage = totalRecord / pageRecord + 1;
        }

        PageBean<UserAccount> pageBean = new PageBean<>();
        pageBean.setBeanList(userAccounts);
        pageBean.setPageNum(pageNum);
        pageBean.setPageRecord(pageRecord);
        pageBean.setTotalRecord(totalRecord);
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }

    @Override
    public UserAccount getById(int id) throws Exception {
        UserAccount userAccount = userAccountMapper.findById(id);
        return userAccount;
    }

    @Override
    public int insert(UserAccount userAccount) throws Exception {
        return userAccountMapper.addUserAccount(userAccount);
    }

    @Override
    public void delete(int id) throws Exception {
        userAccountMapper.deleteUserAccount(id);
    }

    @Override
    public void update(int id, UserAccount userAccount) throws Exception {
        userAccountMapper.editUserAccount(id, userAccount);
    }

    @Override
    public PageBean<UserAccount> queryList(int offset, int pageRecord, UserAccount userAccount) throws Exception {
        List<UserAccount> userAccounts = userAccountMapper.queryAll(offset, pageRecord, userAccount);
        int totalRecord = userAccountMapper.countUserAccount(userAccount);
        int pageNum = offset / pageRecord + 1;

        //计算机总页数
        int totalPage;
        if (totalRecord % pageRecord == 0){
            totalPage = totalRecord/pageRecord;
        } else {
            totalPage = totalRecord/pageRecord + 1;
        }
        PageBean<UserAccount> pageBean = new PageBean<>();   // 将分页数据封装到PageBean中
        pageBean.setBeanList(userAccounts);
        pageBean.setPageNum(pageNum);
        pageBean.setPageRecord(pageRecord);
        pageBean.setTotalRecord(totalRecord);
        pageBean.setTotalPage(totalPage);

        return pageBean;       // 返回封装后的数据
    }

    @Override
    public UserAccount login(UserAccount userAccount) {
        UserAccount userAccount1 = userAccountMapper.findByName(userAccount.getName());
        if (userAccount1 == null) {
            return null;
        } else {
            String password = userAccount.getPassword();
            if (password.equals(userAccount.getPassword())) {
                return userAccount1;
            } else {
                return null;
            }
        }
    }

    @Override
    public int changePassword(int id, String password) {
        return userAccountMapper.changePassword(id,password);
    }
}
