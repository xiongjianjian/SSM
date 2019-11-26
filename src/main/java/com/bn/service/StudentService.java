package com.bn.service;

import com.bn.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();
    public void add();
}
