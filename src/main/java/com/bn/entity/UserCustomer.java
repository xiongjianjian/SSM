package com.bn.entity;

/**
 * @Author: xiongjianjian
 * @Description:
 * @Date: 2019/11/22 11:11
 * @Modified: xiongjianjian
 **/
public class UserCustomer {
    private Integer id;
    private String account;
    private String passWord;
    private String userName;
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
