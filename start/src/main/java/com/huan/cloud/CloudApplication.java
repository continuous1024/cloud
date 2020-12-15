package com.huan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;

@SpringBootApplication(exclude={MybatisAutoConfiguration.class})
public class CloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudApplication.class, args);
    }

}
