package com.zhangpk.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created By zhangpk On 2019/6/22
 **/
@RestController
public class TestController{

    private final RestTemplate restTemplate;

    /**
     * 构造函数注入，官方这样写的，其实平时我不会这样写，也照着找找感觉，哈哈
     *
     * @param restTemplate
     */
    @Autowired
    public TestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @NacosInjected
    private NamingService namingService;

    /**
     * 获取服务实例，通过nacos提供的NamingService
     * @param serviceName
     * @return
     * @throws NacosException
     */
    @RequestMapping(value = "/getService/{serviceName}")
    public List<Instance> getService(@PathVariable String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }


    @Autowired
    LoadBalancerClient loadBalancerClient;
    @RequestMapping(value = "/get/{msg}")
    public String getProviderMsg(@PathVariable String msg){
        return restTemplate.getForObject("http://service-provider/get/" + msg, String.class);
        // 当然也可以同通过注入loadBalancerClient来获取服务地址
            /*ServiceInstance serviceInstance = loadBalancerClient.choose("service-provider");
            String url = serviceInstance.getUri() + "/get/" + msg;*/
    }


}
