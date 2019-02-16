package com.itmuch.cloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeFromComponenScan // 记得加上这个注解才会生效
public class TestConfiguration {
    @Bean
    public IRule ribbonRule() {
        return new RandomRule(); // 随机规则
    }

}
