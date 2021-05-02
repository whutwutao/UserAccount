package com.whut.useraccount.mapper;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.whut.useraccount.bean.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserAccountMapper {
    /**
     * 添加用户
     * @param userAccount
     * @return
     */
    int addUserAccount(UserAccount userAccount);

    /**
     *
     * @param offset 偏移量
     * @param pageRecord 每页记录数
     * @return
     */
    List<UserAccount> findAll(@Param("offset") int offset, @Param("pageRecord") int pageRecord);

    /**
     * 按id查询
     * @param id
     * @return
     * @throws Exception
     */
    UserAccount findById(int id) throws Exception;

    UserAccount findByName(String name);

    int changePassword(@Param("id") int id, @Param("password") String password);

    int deleteUserAccount(int id) throws Exception;

    void editUserAccount(@Param("id") int id, @Param("userAccount") UserAccount userAccount) throws Exception;

    /**
     * 模糊查询时返回模糊查询结果的总个数
     * @param userAccount
     * @return
     * @throws Exception
     */
    int countUserAccount(@Param("userAccount") UserAccount userAccount) throws Exception;

    /**
     * 分页查询用户，并且进行模糊查询
     * @param offset
     * @param pageRecord
     * @param userAccount
     * @return
     * @throws Exception
     */
    List<UserAccount> queryAll(@Param("offset") int offset, @Param("pageRecord") int pageRecord, @Param("userAccount") UserAccount userAccount) throws Exception;


}
