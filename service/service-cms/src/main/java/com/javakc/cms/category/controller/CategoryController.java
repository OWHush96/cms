package com.javakc.cms.category.controller;

import com.javakc.cms.category.entity.Category;
import com.javakc.cms.category.service.CategoryService;
import com.javakc.cms.category.vo.FirstCategory;
import com.javakc.commonutils.api.APICODE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description:分类表现层
 * @Date:2021/1/16 001612:33
 **/
@Api(tags="分类管理")
@RestController
@RequestMapping("/cms/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value="获取树形结构数据 - 分类管理")
    @GetMapping
    public APICODE getCategoryList(){
        List<FirstCategory> list=categoryService.getCategoryList();
        return APICODE.OK().data("items",list);
    }
}

