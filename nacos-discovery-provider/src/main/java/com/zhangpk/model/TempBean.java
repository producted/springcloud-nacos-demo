package com.zhangpk.model;

/**
 *
 * 这里简单定义一个对象来进行调用，看看feign通过对象应该如何调用provider服务
 *
 * Created By zhangpk On 2019/6/22
 **/
public class TempBean {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
