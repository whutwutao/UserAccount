package com.whut.useraccount.mapper;

import com.whut.useraccount.bean.UserAccount;
import com.whut.useraccount.mapper.UserAccountMapper;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserAccountMapperTest {

    @Resource
    UserAccountMapper userAccountMapper;

    @Test
    public void addUserAccountTest() {

        UserAccount userAccount = new UserAccount();
        userAccount.setName("张三");
        userAccount.setGender("male");
        userAccount.setPassword("123456");
        userAccount.setDeposit(2000f);
        userAccount.setBirth(new Date());
        userAccountMapper.addUserAccount(userAccount);
    }

    @Test
    public void findAllTest() {
        List<UserAccount> list = userAccountMapper.findAll(0,5);
        for (UserAccount userAccount : list) {
            System.out.println(userAccount);
        }
    }

    @Test
    public void findByIdTest() {
        try {
            UserAccount userAccount = userAccountMapper.findById(9);
            System.out.println(userAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void countUserAccountTest() {
        UserAccount userAccount = new UserAccount();
        userAccount.setName("a");
        try {
            int cnt = userAccountMapper.countUserAccount(userAccount);
            System.out.println(cnt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteUserAccountTest() {
        try {
            userAccountMapper.deleteUserAccount(13);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void editUserAccountTest() {
        try {
            UserAccount userAccount = userAccountMapper.findById(9);
            userAccount.setDeposit(8000f);
            userAccountMapper.editUserAccount(9,userAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryAllTest() throws Exception{

    }

    @Test
    public void findByName() {
        UserAccount userAccount = userAccountMapper.findByName("曹操");
        System.out.println(userAccount);
    }

    @Test
    public void changePassword() {
        userAccountMapper.changePassword(33,"123456789");
    }
}
