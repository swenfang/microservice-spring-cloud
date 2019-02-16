package com.itmuch.cloud.controller;

import com.google.common.collect.Lists;
import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.repository.UserReposittory;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserReposittory userReposittory;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id){
        return  this.userReposittory.findOne(id);
    }

    @GetMapping("/eureka-instance")
    public String serviceUrl(){
        InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER",false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/eureka-info")
    public ServiceInstance showInfo(){
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user){
        return user;
    }

    @GetMapping("/list-all")
    public List<User> listAll(){
        ArrayList<User> list = Lists.newArrayList();
        User user = new User(1L,"zhangsan");
        User user1 = new User(2L,"lisi");
        User user2 = new User(3L,"wangwu");
        User user3 = new User(4L,"zhaoliu");
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }


}
