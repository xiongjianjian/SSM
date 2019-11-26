package com.bn.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: xiongjianjian
 * @Description:
 * @Date: 2019/11/20 8:37
 * @Modified: xiongjianjian
 **/
public class CustormException implements HandlerExceptionResolver {
    private static Logger logger = LoggerFactory.getLogger(CustormException.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exc) {
        ModelAndView modelAndView = new ModelAndView();
        //获取请求路径
        String requestPath = request.getRequestURI();
        //输出日志信息
        logger.info(requestPath+exc.getMessage());
        String MSG = exc.getMessage();
        modelAndView.addObject("MSG",MSG);
        return modelAndView;
    }
}
