package com.itmuch.cloud.feign;

import com.itmuch.cloud.config.Configuration2;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name="xxxx",url = "http://localhost:8761/",configuration = Configuration2.class)
public interface FeignClient2 {
   /* @RequestMapping(value = "/eureka/apps/{serviceName}",method = RequestMethod.GET)
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);*/

    @RequestLine("GET /eureka/apps/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@Param("serviceName") String serviceName);
}
