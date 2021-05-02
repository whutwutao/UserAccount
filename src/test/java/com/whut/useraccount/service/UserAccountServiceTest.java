package com.whut.useraccount.service;

import com.whut.useraccount.bean.PageBean;
import com.whut.useraccount.bean.UserAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class UserAccountServiceTest {
    @Autowired
    private UserAccountService userAccountService;

    @Test
    public void allList() throws Exception {
        PageBean<UserAccount> pageBean = userAccountService.allList(0,8);
        System.out.println(pageBean);
    }

    @Test
    public void getById() throws Exception {
        int id = 9;
        UserAccount userAccount = userAccountService.getById(9);
        System.out.println(userAccount);
    }

    @Test
    public void insert() throws Exception {
        UserAccount userAccount = new UserAccount();
        userAccount.setName("李云龙");
        userAccount.setGender("male");
        userAccount.setBirth(new Date());
        userAccount.setPassword("123456");
        userAccount.setDeposit(3000f);
        userAccountService.insert(userAccount);
    }

    @Test
    public void delete() throws Exception {
        int id = 2;
        userAccountService.delete(2);
    }

    @Test
    public void update() throws Exception {
        int id = 14;
        UserAccount userAccount = userAccountService.getById(id);
        userAccount.setName("赵刚");
        userAccountService.update(id,userAccount);
    }

    @Test
    public void queryList() throws Exception {
        int offset = 0;
        int pageRecord = 10;
        UserAccount userAccount = new UserAccount();
        userAccount.setName("刚");
        PageBean<UserAccount> pageBean = userAccountService.queryList(offset,pageRecord,userAccount);
        System.out.println(pageBean);
    }
}
