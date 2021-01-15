package com.javak.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description:
 * @Date:2021/1/15 00150:55
 **/
// ## exclude = DataSourceAutoConfiguration.class 当前服务启动时没有提供数据源，表示排除数据源
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.javakc"})
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class,args);
    }
}

