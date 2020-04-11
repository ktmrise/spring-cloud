package com.ktm.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @Author: rise
 * @create: 2020-04-11 11:28
 **/

@Configuration
public class ApplicationContextConfig {


    @Bean
    public RestTemplate getRestTemplate(){
        return new  RestTemplate();
    }

}
