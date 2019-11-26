package com.bn.dao;

import com.bn.entity.Role;
import com.bn.entity.UserCustomer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: xiongjianjian
 * @Description:
 * @Date: 2019/11/22 11:13
 * @Modified: xiongjianjian
 **/
public interface UserDao {
    public UserCustomer selectUserByAccountAndPassword(UserCustomer user);
    public List<Role> selectAuthByAccount(UserCustomer user);
}
