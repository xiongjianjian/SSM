package com.bn.service.impl;

import com.bn.controller.StudentController;
import com.bn.dao.StudentDao;
import com.bn.entity.Student;
import com.bn.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        logger.info("StudentImpl findAll Start");
        return studentDao.findAll();
    }
}
