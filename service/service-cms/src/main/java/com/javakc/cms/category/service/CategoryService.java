package com.javakc.cms.category.service;

import com.javakc.cms.category.dao.CategoryDao;
import com.javakc.cms.category.entity.Category;
import com.javakc.cms.category.vo.FirstCategory;
import com.javakc.cms.category.vo.SecondCategory;
import com.javakc.commonutils.jpa.base.service.BaseService;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecification;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecificationBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description:
 * @Date:2021/1/16 001611:32
 **/
@Service
public class CategoryService extends BaseService<CategoryDao, Category> {
    @Autowired
    private CategoryDao categoryDao;

    /**
     * 获取树形分类结构
     * @return
     */
    public List<FirstCategory> getCategoryList(){
        // ##查询一级分类 查询一级分类parentId=0
        Specification<Category> firstSpecification = new SimpleSpecificationBuilder<>().and("level1Id","=","0").getSpecification();
        List<Category> firstCategories=categoryDao.findAll(firstSpecification);

        // ##查询二级分类
        Specification<Category> secondSpecification = new SimpleSpecificationBuilder<>().and("level1Id","!=","0").getSpecification();
        List<Category> secondCategories=categoryDao.findAll(secondSpecification);

        // ##创建一级分类集合
        List<FirstCategory> firstCategoryList=new ArrayList<>();

        // ##循环一级分类
        for(int i=0;i<firstCategories.size();i++){
            // ## 获取一级分类数据
            Category category1=firstCategories.get(i);
            // ##创建一级分类封装对象
            FirstCategory firstCategory=new FirstCategory();
            BeanUtils.copyProperties(category1,firstCategory);

            // ##创建二级分类封装对象的集合
            List<SecondCategory> secondCategoryList =new ArrayList<>();
            // ##循环二级分类
            for (int j = 0; j < secondCategories.size(); j++) {
                Category category2=secondCategories.get(j);
                // ## 当前的二级分类内容是属于当前一级分类
                if(category1.getId().equals(category2.getLevel1Id())){
                    // ##创建二级分类封装对象
                    SecondCategory secondCategory=new SecondCategory();
                    BeanUtils.copyProperties(category2,secondCategory);
                    // ##放置到二级分类封装集合当中
                    secondCategoryList.add(secondCategory);

                }

            }
            // ## 放置到一级分类的对象当中
            firstCategory.setSecondCategoryList(secondCategoryList);
            // ## 把当前的一级分类封装放置到一级分类封装对象的集合当中
            firstCategoryList.add(firstCategory);
        }


        return firstCategoryList;
    }
}

