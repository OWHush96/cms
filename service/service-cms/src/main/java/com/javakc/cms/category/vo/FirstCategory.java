package com.javakc.cms.category.vo;

import com.javakc.cms.category.entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description:一级分类查询条件
 * @Date:2021/1/16 001613:46
 **/
@Setter
@Getter
public class FirstCategory {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 二级分类集合
     */
    private List<SecondCategory> secondCategoryList;

}

