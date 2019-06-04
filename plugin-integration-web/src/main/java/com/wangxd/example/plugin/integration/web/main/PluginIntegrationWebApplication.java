package com.wangxd.example.plugin.integration.web.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.wangxd.example.plugin.integration.persistent.dao")
@ComponentScan(basePackages = {"com.wangxd.example.plugin.integration.*.*"})
public class PluginIntegrationWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PluginIntegrationWebApplication.class, args);
    }

}
