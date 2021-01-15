package com.javakc.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description: 阿里云OSS云存储 - 读取配置文件类
 * @Date:2021/1/15 00151:00
 **/
@Component
public class PropertiesUtils implements InitializingBean {

    // ## 通过注解注入的方式读取配置文件属性
    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.file.keyid}")
    private String keyid;
    @Value("${aliyun.oss.file.keysecret}")
    private String keysecret;
    @Value("${aliyun.oss.file.bucketname}")
    private String bucketname;

    // ## 定义公共访问的属性
    public static String END_POINT;
    public static String KEY_ID;
    public static String KEY_SECRET;
    public static String BUCKET_NAME;

    /**
     *项目启动后，实例化该类，交给spring管理
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT=endpoint;
        KEY_ID=keyid;
        KEY_SECRET=keysecret;
        BUCKET_NAME=bucketname;
    }


}

