package com.bn.service.impl;

import com.bn.controller.StudentController;
import com.bn.dao.StudentDao;
import com.bn.entity.Student;
import com.bn.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        logger.info("StudentImpl findAll Start");
        //PageHelper.startPage(1,5);
        List<Student> userList=studentDao.findAll();
        //PageInfo<Student> pageInfo = new PageInfo<Student>(userList);
        //List<Student> list = pageInfo.getList();
        return userList;
    }

    @Override
    public void add() {

    }
}
