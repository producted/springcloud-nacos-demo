package com.zhangpk.controller;

import com.zhangpk.model.TempBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * Created By zhangpk On 2019/6/22
 **/
@RestController
@RefreshScope // springcloud原生注解 用来干嘛呢，用来实现配置的自动更新
public class TestAction {

    @RequestMapping(value = "/get")
    public String get(@RequestBody TempBean tempBean){
        return "I Am 18082,Hello PathVariable Is " + tempBean.getMsg();
    }

    // 通过自定义的一个配置来实现配置更新example
    @Value("${my.test.value}")
    private String whatValue;

    @RequestMapping(value = "/lookValue")
    public String selectValue(){
        return whatValue;
    }
}
