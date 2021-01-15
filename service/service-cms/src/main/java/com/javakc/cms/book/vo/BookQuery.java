package com.javakc.cms.book.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description:查询条件封装类
 * @Date:2021/1/13 001312:12
 **/
@Data
public class BookQuery {
//    private int id;
    private String bookName;

    private String beginDate;

    private String endDate;
//    private String author;
//    private Byte isSerialize;
//    private Byte isOnline;
//    private Byte isOriginal;
//    private int level2Id;
//    private Byte isCharge;
}

