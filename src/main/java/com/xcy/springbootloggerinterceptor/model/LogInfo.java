package com.xcy.springbootloggerinterceptor.model;

import java.util.Date;
import javax.persistence.*;

public class LogInfo {
    /**
     * id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 客户端请求ip
     */
    @Column(name = "log_client_ip")
    private String logClientIp;

    /**
     * 客户端请求路径
     */
    @Column(name = "log_uri")
    private String logUri;

    /**
     * 请求方式(普通请求,ajax请求)
     */
    @Column(name = "log_type")
    private String logType;

    /**
     * 请求方式(get,post)
     */
    @Column(name = "log_method")
    private String logMethod;

    /**
     * 请求接口唯一session标识
     */
    @Column(name = "log_session_id")
    private String logSessionId;

    /**
     * 请求时间
     */
    @Column(name = "log_time")
    private Date logTime;

    /**
     * 接口返回时间
     */
    @Column(name = "log_return_time")
    private String logReturnTime;

    /**
     * 接口返回json
     */
    @Column(name = "log_return_data")
    private String logReturnData;

    /**
     * http接口返回状态码
     */
    @Column(name = "log_http_status_code")
    private String logHttpStatusCode;

    @Column(name = "log_time_consuming")
    private Integer logTimeConsuming;

    /**
     * 请求的参数json
     */
    @Column(name = "log_param_data")
    private String logParamData;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取客户端请求ip
     *
     * @return log_client_ip - 客户端请求ip
     */
    public String getLogClientIp() {
        return logClientIp;
    }

    /**
     * 设置客户端请求ip
     *
     * @param logClientIp 客户端请求ip
     */
    public void setLogClientIp(String logClientIp) {
        this.logClientIp = logClientIp;
    }

    /**
     * 获取客户端请求路径
     *
     * @return log_uri - 客户端请求路径
     */
    public String getLogUri() {
        return logUri;
    }

    /**
     * 设置客户端请求路径
     *
     * @param logUri 客户端请求路径
     */
    public void setLogUri(String logUri) {
        this.logUri = logUri;
    }

    /**
     * 获取请求方式(普通请求,ajax请求)
     *
     * @return log_type - 请求方式(普通请求,ajax请求)
     */
    public String getLogType() {
        return logType;
    }

    /**
     * 设置请求方式(普通请求,ajax请求)
     *
     * @param logType 请求方式(普通请求,ajax请求)
     */
    public void setLogType(String logType) {
        this.logType = logType;
    }

    /**
     * 获取请求方式(get,post)
     *
     * @return log_method - 请求方式(get,post)
     */
    public String getLogMethod() {
        return logMethod;
    }

    /**
     * 设置请求方式(get,post)
     *
     * @param logMethod 请求方式(get,post)
     */
    public void setLogMethod(String logMethod) {
        this.logMethod = logMethod;
    }

    /**
     * 获取请求接口唯一session标识
     *
     * @return log_session_id - 请求接口唯一session标识
     */
    public String getLogSessionId() {
        return logSessionId;
    }

    /**
     * 设置请求接口唯一session标识
     *
     * @param logSessionId 请求接口唯一session标识
     */
    public void setLogSessionId(String logSessionId) {
        this.logSessionId = logSessionId;
    }

    /**
     * 获取请求时间
     *
     * @return log_time - 请求时间
     */
    public Date getLogTime() {
        return logTime;
    }

    /**
     * 设置请求时间
     *
     * @param logTime 请求时间
     */
    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    /**
     * 获取接口返回时间
     *
     * @return log_return_time - 接口返回时间
     */
    public String getLogReturnTime() {
        return logReturnTime;
    }

    /**
     * 设置接口返回时间
     *
     * @param logReturnTime 接口返回时间
     */
    public void setLogReturnTime(String logReturnTime) {
        this.logReturnTime = logReturnTime;
    }

    /**
     * 获取接口返回json
     *
     * @return log_return_data - 接口返回json
     */
    public String getLogReturnData() {
        return logReturnData;
    }

    /**
     * 设置接口返回json
     *
     * @param logReturnData 接口返回json
     */
    public void setLogReturnData(String logReturnData) {
        this.logReturnData = logReturnData;
    }

    /**
     * 获取http接口返回状态码
     *
     * @return log_http_status_code - http接口返回状态码
     */
    public String getLogHttpStatusCode() {
        return logHttpStatusCode;
    }

    /**
     * 设置http接口返回状态码
     *
     * @param logHttpStatusCode http接口返回状态码
     */
    public void setLogHttpStatusCode(String logHttpStatusCode) {
        this.logHttpStatusCode = logHttpStatusCode;
    }

    /**
     * @return log_time_consuming
     */
    public Integer getLogTimeConsuming() {
        return logTimeConsuming;
    }

    /**
     * @param logTimeConsuming
     */
    public void setLogTimeConsuming(Integer logTimeConsuming) {
        this.logTimeConsuming = logTimeConsuming;
    }

    /**
     * 获取请求的参数json
     *
     * @return log_param_data - 请求的参数json
     */
    public String getLogParamData() {
        return logParamData;
    }

    /**
     * 设置请求的参数json
     *
     * @param logParamData 请求的参数json
     */
    public void setLogParamData(String logParamData) {
        this.logParamData = logParamData;
    }
}