package com.bn.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer id;
    private String classno;
    private String ClassesName;
    private String StuName;
    private Integer age;
    private String sex;

    public String getClassesName() {
        return ClassesName;
    }

    public void setClassesName(String classesName) {
        ClassesName = classesName;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
