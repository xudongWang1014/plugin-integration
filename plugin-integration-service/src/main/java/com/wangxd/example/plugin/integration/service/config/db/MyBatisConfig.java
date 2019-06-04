//package com.wangxd.example.plugin.integration.service.config;
//
//
//import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MyBatisConfig {
//
//    @Bean
//    public ConfigurationCustomizer configurationCustomizer(){
//        return new ConfigurationCustomizer(){
//            public void customize(org.apache.ibatis.session.Configuration configuration) {
//                //开启驼峰命名法
//                configuration.setMapUnderscoreToCamelCase(true);
//            }
//        };
//    }
//
//}
