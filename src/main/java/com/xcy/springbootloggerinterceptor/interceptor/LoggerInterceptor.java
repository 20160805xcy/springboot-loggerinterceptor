package com.xcy.springbootloggerinterceptor.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xcy.springbootloggerinterceptor.model.LogInfo;
import com.xcy.springbootloggerinterceptor.service.LogInfoService;
import com.xcy.springbootloggerinterceptor.util.LoggerUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xcy
 * @date 2018/12/04 14:19
 * @description 日志拦截器
 * @since V1.0.0
 */
public class LoggerInterceptor implements HandlerInterceptor {

    //请求开始时间标识
    private static final String LOGGER_SEND_TIME = "_send_time";
    //请求日志实体标识
    private static final String LOGGER_ENTITY = "_logger_entity";


    /**
     * 1.前处理
     * 进入springMVC的Controller之前开始记录日志实体
     * 在业务处理器处理请求之前被调用.预处理,可以进行编码,安全控制,权限校验等处理;
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LogInfo logInfo = new LogInfo();
        String sessionId = request.getRequestedSessionId();
        String uri = request.getRequestURI();
        String paramData = JSON.toJSONString(request.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        logInfo.setLogClientIp(LoggerUtils.getClientIp(request));
        logInfo.setLogUri(uri);
        logInfo.setLogType(LoggerUtils.getRequestType(request));
        logInfo.setLogMethod(request.getMethod());
        logInfo.setLogParamData(paramData);
        logInfo.setLogSessionId(sessionId);
        //设置请求开始时间
        request.setAttribute(LOGGER_SEND_TIME, System.currentTimeMillis());
        //设置请求实体到request内,方便afterCompletion方法调用
        request.setAttribute(LOGGER_ENTITY, logInfo);
        return true;
    }

    /**
     * 2.后处理
     * 在业务处理器处理请求执行完成后,生成视图之前执行.后处理(调用了Service并返回ModelAndView,但未进行页面渲染),有机会修改ModelAndView;
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    /**
     * 3.终处理
     * 请求被完成处理后,页面已经渲染完成时调用此方法
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等.返回处理(已经渲染了页面);
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //获取请求错误码
        int status = response.getStatus();
        long endTime = System.currentTimeMillis();
        Long startTime = Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());
        LogInfo logInfo = (LogInfo) request.getAttribute(LOGGER_ENTITY);
        //结束时间
        logInfo.setLogReturnTime(String.valueOf(endTime));
        //请求耗时
        logInfo.setLogTimeConsuming(Integer.valueOf((endTime - startTime) + ""));
        //设置返回值
        logInfo.setLogReturnData(JSON.toJSONString(request.getAttribute(LoggerUtils.LOGGER_RETURN),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        //设置返回状态
        logInfo.setLogHttpStatusCode(String.valueOf(status));

        //将执行日志写入到数据库
        LogInfoService logInfoService = (LogInfoService) WebApplicationContextUtils.getRequiredWebApplicationContext(
                request.getServletContext()).getBean("logInfoService");

        logInfoService.insertLog(logInfo);

    }
}
