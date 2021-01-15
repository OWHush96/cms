package com.javakc.oss.controller;

import com.javakc.commonutils.api.APICODE;
import com.javakc.oss.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description:阿里云OSS存储控制器
 * @Date:2021/1/15 00151:30
 **/
@Api(tags="阿里云OSS-存储控制器")
@RestController
@RequestMapping("/oss")
public class OssController {

    @Autowired
    private OssService ossService;

    @ApiOperation(value="上传文件",notes="阿里云OSS存储")
    @PostMapping("uploadFile")
    public APICODE uploadFile(MultipartFile file){
        String uploadUrl = ossService.uploadFile(file);
        return APICODE.OK().message("上传文件成功").data("uploadUrl",uploadUrl);


    }
}

