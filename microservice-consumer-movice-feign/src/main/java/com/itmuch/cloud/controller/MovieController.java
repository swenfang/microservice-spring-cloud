package com.itmuch.cloud.controller;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
  * @Author shenwenfang
  * @Date 2018/12/16 19:46
  * @Description: 
  */
@RestController
public class MovieController {

    // 调用
    @Autowired
    private UserFeignClient user;

    @GetMapping("/movice/{id}")
    public User findById(@PathVariable Long id){
        return user.findById(id);
    }

    @GetMapping("/test")
    public User testPost(User user){
        return this.user.postUser(user);
    }

}
