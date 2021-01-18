package com.javakc.oss.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.javakc.oss.utils.PropertiesUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description:
 * @Date:2021/1/15 00151:09
 **/
@Service
public class OssService {
    /**
     * 上传文件至阿里云OSS存储
     * @param file
     * @return
     */
    public String uploadFile(MultipartFile file){
        // ## 读取配置文件
        String endPoint=PropertiesUtils.END_POINT;
        String keyId=PropertiesUtils.KEY_ID;
        String keySecret = PropertiesUtils.KEY_SECRET;
        String bucketName = PropertiesUtils.BUCKET_NAME;

        //返回上传后的文件路径
        String uploadUrl=null;

        try{
            // Endpoint以杭州为例，其它Region请按实际情况填写。
            String endpoint = endPoint;
            // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
            String accessKeyId = keyId;
            String accessKeySecret = keySecret;

            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 获取文件流
            InputStream inputStream = file.getInputStream();

            // 日期路径
            String filePath= new SimpleDateFormat("yyyy/MM/dd").format(new Date());

            // 设置文件名
            String originFileName=file.getOriginalFilename();
            String fileName= UUID.randomUUID().toString().replaceAll("-","");
            String fileType=originFileName.substring(originFileName.indexOf("."));
            String newName=fileName+fileType;

            String url="image/"+filePath+"/"+newName;

            // 上传文件流。
            ossClient.putObject(bucketName, url, inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();

            //http://owhush96.oss-cn-beijing.aliyun.com/0.jpg
            uploadUrl="http://"+ bucketName+"."+endPoint+"/"+url;

        }catch(Exception e){
            e.printStackTrace();
        }


        return uploadUrl;
    }
}

