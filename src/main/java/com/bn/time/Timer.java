package com.bn.time;

import com.bn.controller.StudentController;
import com.bn.dao.StudentDao;
import com.bn.entity.Student;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xiongjianjian
 * @Description:
 * @Date: 2019/11/19 16:49
 * @Modified: xiongjianjian
 **/
@Component
public class Timer {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentDao studentDao;

    //@Scheduled(cron = "1/5 * * * * ?")
    public void add() {
        logger.info("Scheduled 定时任务开启" + new Date());
        Student student = new Student();
        student.setClassno("006");
        student.setStuName("tom");
        student.setAge(10);
        student.setSex("男");
        studentDao.add(student);
    }

    @Scheduled(cron = "0 0 23 * * ?")
    public void backUp() {
        logger.info("###数据库生成备份文件");
        doBackUp();
    }

  /*  @Scheduled(cron = "0/50 * * * * ?")
    public void restore() {
        logger.info("###数据库还原备份文件");
        doRestore();
    }*/

    public static void doBackUp() {
        Runtime runtime = Runtime.getRuntime();  //获取Runtime实例
        String dataBase = "school"; // 需要备份的数据库名
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String sdfDate = sdf.format(currentDate);
        String filepath = "E:\\dbBackUp\\time_" + sdfDate + ".sql"; // 备份的路径地址
        //执行命令
        String stmt = "D:\\BNUtil\\mysql\\bin\\mysqldump -h localhost -u root -proot --databases " + dataBase + " > " + filepath;
        //logger.info(stmt);
        try {
            String[] command = {"cmd", "/c", stmt};
            Process process = runtime.exec(command);
            InputStream input = process.getInputStream();
            logger.info(IOUtils.toString(input, "UTF-8"));
            //若有错误信息则输出
            InputStream errorStream = process.getErrorStream();
            logger.info(IOUtils.toString(errorStream, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void doRestore() {
        Runtime runtime = Runtime.getRuntime();
        try {
            String filePath = "E:\\dbBackUp\\time_2019-11-20_15-58-00.sql"; // sql文件路径
            String stmt = "D:\\BNUtil\\mysql\\bin\\mysql -h localhost -u root -proot < " + filePath;
            //将命令放入cmd执行成功即可
            logger.info(stmt);
            String[] command = {"cmd", "/c", stmt};
            Process process = runtime.exec(command);
            //若有错误信息则输出
            InputStream errorStream = process.getErrorStream();
            logger.info(IOUtils.toString(errorStream, "UTF-8"));
            //等待操作
            int processComplete = process.waitFor();
            if (processComplete == 0) {
                System.out.println("还原成功.");
            } else {
                throw new RuntimeException("还原数据库失败.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
