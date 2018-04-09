package com.forezp.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by huxinglong on 2018/3/20.
 */
@FeignClient(value = "service-hello", fallback =SchedualServiceHi.hiError.class)
//@FeignClient(value = "consul-miya")
public interface SchedualServiceHi {
    //@HystrixCommand(fallbackMethod = "fallbackMethodTest")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    @Component
    class hiError implements SchedualServiceHi{
        @Override
        public String sayHiFromClientOne(String name) {
            return "hi,"+name+",sorry,error!";
        }
    }
}