package com.xcy.springbootloggerinterceptor.controller;

import com.alibaba.fastjson.JSONObject;
import com.xcy.springbootloggerinterceptor.util.LoggerUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xcy
 * @date 2018/12/04 14:07
 * @description 日志记录
 * @since V1.0.0
 */
@RestController
@RequestMapping("loginfo")
public class LogInfoController {

    @RequestMapping("login")
    public JSONObject login(HttpServletRequest request, String name) {
        JSONObject obj = new JSONObject();
        obj.put("msg", "用户:" + name + ",登录成功.");
        request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
        return obj;
    }

    //这个方法访问是不会被拦截器拦截到的,在拦截器配置类里面已经排除
    @RequestMapping("token")
    public JSONObject token(HttpServletRequest request, String name) {
        JSONObject obj = new JSONObject();
        obj.put("msg", "用户:" + name + ",获取token成功.");
        request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
        return obj;
    }

}
