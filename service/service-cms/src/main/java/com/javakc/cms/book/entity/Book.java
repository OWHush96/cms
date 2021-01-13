package com.javakc.cms.book.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description:书籍
 * @Date:2021/1/12 001213:22
 **/
@Setter
@Getter
@Entity
@Table(name="cms_content_book")
@EntityListeners(AuditingEntityListener.class)
public class Book
    {
        @Id
        @Column
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @ApiModelProperty(value="书籍主键")
        private Integer id;

        @Column(name="book_name")
        @ApiModelProperty(value="书名")
        private String bookName;

        @Column(name="author")
        @ApiModelProperty(value="作者")
        private String author;

        @Column(name="level2_id")
        @ApiModelProperty(value="二级分类")
        private Integer level2Id;

        @Column(name="copyright_id")
        @ApiModelProperty(value="版本")
        private Integer copyrightId;

        @Column(name="is_serialize")
        @ApiModelProperty(value="是否连载")
        private Byte isSerialize;

        @Column(name="is_original")
        @ApiModelProperty(value="是否原创")
        private Byte isOriginal;

        @Column(name="grant_start_time")
        @ApiModelProperty(value="授权开始时间",example="2021-12-12 13:32:00")
        private Date grant_start_time;

        @Column(name="grant_end_time")
        @ApiModelProperty(value="授权结束时间",example="2021-12-12 13:34:00")
        private Date grant_end_time;

        @Column(name="introduction")
        @ApiModelProperty(value="简介")
        private String introduction;

        @Column(name="book_cover")
        @ApiModelProperty(value="书封")
        private String bookCover;

        @Column(name="word_number")
        @ApiModelProperty(value="字数")
        private Integer wordNumber;

        @Column(name="is_online")
        @ApiModelProperty(value="状态")
        private Byte isOnline;

        @Column(name="is_charge")
        @ApiModelProperty(value="全本收费")
        private Byte isCharge;

        @Column(name="revision")
        @ApiModelProperty(value="乐观锁")
        private Integer revision;

        @Column(name="created_by")
        @ApiModelProperty(value="创建人")
        private String createdBy;

        @CreatedDate
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
        @Column(name="gmt_created",nullable=false,updatable=false)
        @ApiModelProperty(value="创建时间")
        private Date gmtCreated;

        @Column(name="updated_by")
        @ApiModelProperty(value="更新人")
        private String updatedBy;

        @LastModifiedDate
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
        @Column(name="gmt_modified",nullable=false,insertable = false)
        @ApiModelProperty(value="更新时间")
        private Date gmtModified;
}

