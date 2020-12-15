package com.huan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication(exclude={MybatisAutoConfiguration.class, FeignAutoConfiguration.class})
public class CloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudApplication.class, args);
    }

}
