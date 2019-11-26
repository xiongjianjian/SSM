package com.bn.dao;

import com.bn.entity.Student;

import java.util.List;

public interface StudentDao {
    /**
     * 查询所有学生信息
     * @return
     */
    public List<Student> findAll();
    public int add(Student student);
}
