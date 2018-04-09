package com.forezp.web;

import com.forezp.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by hl on 2018/3/20.
 */
@RestController
public class HiController {

    @Resource
    SchedualServiceHi schedualServiceHi;
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }
    
    @RequestMapping(value = "/baidu",method = RequestMethod.GET)
    public String sayBaidu(@RequestParam String name){
        return schedualServiceHi.getBaiduFromClientOne(name);
    }
    @RequestMapping(value = "/qq",method = RequestMethod.GET)
    public String sayQQ(@RequestParam String name){
    	return schedualServiceHi.getQQFromClientOne(name);
    }
    @RequestMapping(value = "/163",method = RequestMethod.GET)
    public String say163(@RequestParam String name){
    	return schedualServiceHi.get163FromClientOne(name);
    }
    @RequestMapping(value = "/imooc",method = RequestMethod.GET)
    public String sayImooc(@RequestParam String name){
    	return schedualServiceHi.getImoocFromClientOne(name);
    }
}