package com.javakc.cms.category.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description: 分类实体类
 * @Date:2021/1/16 001611:29
 **/
@Getter
@Setter
@Entity
@Table(name="cms_content_level2")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @ApiModelProperty(value="级别主键")
    private Integer id;

    @Column(name="name")
    @ApiModelProperty(value="分类名称")
    private String name;

    @Column(name="level1_id")
    @ApiModelProperty(value="上一级id")
    private Integer level1Id;


}

