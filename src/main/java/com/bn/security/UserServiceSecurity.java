package com.bn.security;

import com.bn.dao.UserDao;
import com.bn.entity.Role;
import com.bn.entity.UserCustomer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiongjianjian
 * @Description:
 * @Date: 2019/11/22 10:31
 * @Modified: xiongjianjian
 **/
@Service("userService")
public class UserServiceSecurity implements UserDetailsService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceSecurity.class);

    @Autowired
    UserDao userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //第一步：通过用户名，去数据库查询用户信息
        UserCustomer userCustomer = new UserCustomer();
        userCustomer.setAccount(s);

        UserCustomer customer = userMapper.selectUserByAccountAndPassword(userCustomer);
        if (customer == null) {
            //logger.warn("User: {} not found", login);
            throw new UsernameNotFoundException("User " + s + " was not found in db");
            //这里找不到必须抛异常
        }
        List<Role> roles = userMapper.selectAuthByAccount(userCustomer);
        //第二步：根据用户信息，实例化，处理自己的用户对象封装成UserDetails
        //如果是使用未加密的帐号和密码校验，请在用户名和密码前面，添加一个标识{noop}
        //  User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        //User user = new User( "eric","123456", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        User user = new User(customer.getAccount(),customer.getPassWord(), getAuthority(roles));
        return user;
    }
    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

}
