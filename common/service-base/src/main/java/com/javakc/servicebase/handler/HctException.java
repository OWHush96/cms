package com.javakc.servicebase.handler;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description:自定义异常类
 * @Date:2021/1/13 001311:26
 **/

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
//提供构造函数
@AllArgsConstructor
//提供无参构造函数
@NoArgsConstructor
public class HctException extends RuntimeException {
    @ApiModelProperty(value="状态码")
    private Integer Code;

    @ApiModelProperty(value="信息")
    private String message;
}

