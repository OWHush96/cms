package com.javakc.commonutils.api;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description:统一数据结果返回
 * @Date:2021/1/13 001310:00
 **/
@Data
public class APICODE {
//    状态码
    private Integer code;
//    返回信息
    private String message;
//    成功或失败
    private Boolean status;
//    返回数据
    private Map<String,Object> data=new HashMap<String,Object>();

    private APICODE(){

    }

    /**
     * 返回成功信息
     * @return
     */
    public static APICODE OK(){
        APICODE apicode=new APICODE();
        apicode.setCode(ResultCode.SUCCESS);
        apicode.setMessage("调用成功");
        apicode.setStatus(true);
        return apicode;
    }

    /**
     * 返回错误信息
     * @return
     */
    public static APICODE ERROR(){
        APICODE apicode =new APICODE();
        apicode.setCode(ResultCode.ERROR);
        apicode.setMessage("调用失败");
        apicode.setStatus(false);
        return apicode;
    }

    public APICODE status(Boolean status){
        this.setStatus(status);
        return this;
    }
    public APICODE message(String message){
        this.setMessage(message);
        return this;
    }
    public APICODE code(Integer code){
        this.setCode(code);
        return this;
    }
    public APICODE data(String key,Object value){
        this.data.put(key,value);
        return this;
    }
    public APICODE data(Map<String,Object> map){
        this.setData(map);
        return this;
    }
}

