package com.zhangpk.controller;

import com.zhangpk.model.TempBean;
import com.zhangpk.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 通过feign来实现服务调用
 *
 * Created By zhangpk On 2019/6/22
 **/
@RestController
public class FeignTestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/getByFeign")
    public String getProviderMsg(@RequestBody TempBean tempBean){
        return testService.getProviderMsg(tempBean);
    }
}
