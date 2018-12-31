package com.itmuch.cloud.feign;
import com.itmuch.cloud.config.Configuration1;
import com.itmuch.cloud.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "microservice-provider-user",configuration = Configuration1.class)
public interface UserFeignClient {
    @RequestLine("GET /simple/{id}")
    public User findById(@Param("id") Long id);
}
