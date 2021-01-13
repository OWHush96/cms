package com.javakc.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description:执行类
 * @Date:2021/1/12 001213:27
 **/
@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages={"com.javakc"})
public class CmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class,args);
    }
}

