package com.zhangpk.service;

import com.zhangpk.model.TempBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created By zhangpk On 2019/6/22
 **/
@FeignClient(value = "service-provider") // 通过该注解指定要调用的服务名 （spring.application.name）
public interface TestService {

    /**
     * 这里有一点，@requestparam内必须指定属性，不指定还给我报错，草
     *
     * @param msg
     * @return
     */
    @RequestMapping(value = "/get")
    String getProviderMsg(@RequestBody TempBean tempBean);
}
