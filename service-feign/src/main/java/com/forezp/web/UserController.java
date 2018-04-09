package com.forezp.web;


import javax.annotation.Resource;

import com.forezp.dto.User;
import com.forezp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Created by huxinglong on 2018/3/29.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Resource
    private DiscoveryClient client;

    @RequestMapping(value="/addUser",method=RequestMethod.POST)
    @ResponseBody
    public int addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @RequestMapping(value="/getUserById",method=RequestMethod.GET)
    @ResponseBody
    public User getUserById(@RequestParam int id){
        return userService.getUserById(id);
    }

    @RequestMapping(value="/getAllUsers",method=RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers(){
        List<User> listUser = userService.getAllUsers();
        //获取服务信息
        ServiceInstance instance = client.getLocalServiceInstance();
        //输出服务信息
        logger.info("uri={}，serviceId={}，result={}", instance.getUri(), instance.getServiceId(),listUser);
        return listUser;
    }
}