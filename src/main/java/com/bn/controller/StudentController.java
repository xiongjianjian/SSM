package com.bn.controller;

import com.bn.entity.Student;
import com.bn.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentService studentService;

    @RequestMapping(value="/findAll",produces="application/json")
    @ResponseBody
    public List<Student> findAll(){
        logger.info("StudentController findAll Start");
        return studentService.findAll();
    }

}
