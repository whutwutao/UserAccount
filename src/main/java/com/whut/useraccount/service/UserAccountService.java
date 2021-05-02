package com.whut.useraccount.service;

import com.whut.useraccount.bean.PageBean;
import com.whut.useraccount.bean.UserAccount;

public interface UserAccountService {

    /**
     * 分页查询
     * @param offset
     * @param pageRecord
     * @return
     * @throws Exception
     */
    PageBean<UserAccount> allList(int offset, int pageRecord) throws Exception;

    /**
     * 按id查询
     * @param id
     * @return
     * @throws Exception
     */
    UserAccount getById(int id) throws Exception;

    /**
     * 添加用户
     * @param userAccount
     * @throws Exception
     */
    int insert(UserAccount userAccount) throws Exception;

    /**
     * 按id删除
     * @param id
     * @throws Exception
     */
    void delete(int id) throws Exception;

    /**
     * 修改信息
     * @param id
     * @param userAccount
     * @throws Exception
     */
    void update(int id, UserAccount userAccount) throws Exception;

    /**
     * 分页查询，模糊查询，
     * @param offset
     * @param pageRecord
     * @param userAccount
     * @return
     * @throws Exception
     */
    PageBean<UserAccount> queryList(int offset, int pageRecord, UserAccount userAccount) throws Exception;


    UserAccount login(UserAccount userAccount);

    int changePassword(int id, String password);
}
