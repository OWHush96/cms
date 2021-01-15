package com.javakc.cms.book.controller;

import com.javakc.commonutils.api.APICODE;
import org.springframework.web.bind.annotation.*;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description:连接类
 * @Date:2021/1/13 001320:22
**/
@RestController
@RequestMapping("/cms/user")
@CrossOrigin
public class LoginController {

    @PostMapping("login")
    public APICODE login(){
        return APICODE.OK().data("token","admin");
    }

    @GetMapping("info")
    public APICODE info(){
        return APICODE.OK().data("role","[admin]").data("name","admin").data("avatar","http://img0.imgth.bdimg.com/it/u=1782959667,617309577&fm=26&gp=O.jpg");
    }
}

