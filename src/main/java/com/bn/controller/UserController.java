package com.bn.controller;

import com.bn.entity.UserCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: xiongjianjian
 * @Description:
 * @Date: 2019/11/22 14:58
 * @Modified: xiongjianjian
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * @Author: xiongjianjian
     * @Description:
     * @Date: 2019/11/22 14:59
     * @Modified: xiongjianjian
     **/
    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response, UserCustomer userCustomer) throws IOException {
        //userCustomer.setAccount(request);
        //ModelAndView modelAndView = new ModelAndView();
       // UserDetails userDetails = userService.login(userCustomer);
        //modelAndView.setViewName("login");
        //return modelAndView;
        //response.sendRedirect("login.jsp");
    }

    @RequestMapping("/logout")
    public void logout() throws IOException {

    }
    @RequestMapping("/index")
    public ModelAndView index() {
    return new ModelAndView("index");
    }
}
