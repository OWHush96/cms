package com.javakc.cms.book.service;

import com.javakc.cms.book.dao.BookDao;
import com.javakc.cms.book.entity.Book;
import com.javakc.cms.book.vo.BookQuery;
import com.javakc.commonutils.jpa.base.service.BaseService;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description:书籍逻辑层
 * @Date:2021/1/12 001212:15
 **/
@Service
public class BookService extends BaseService<BookDao,Book> {

    @Autowired BookDao bookDao;
    public List<Book> findAll(){
        // ##掉用dao方法进行查询
        List<Book> list=bookDao.findAll();
        return list;
    }

    /**
     * 根据条件进行分页查询
     * @param bookQuery
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Book> pageBook(BookQuery bookQuery, Integer pageNo, Integer pageSize){
        /**
         * 可用操作符
         * =等值、!= 不等值（字符串、数字）
         * >=、<=、>、<(数字)
         * ge、le、gt、lt(字符串)
         * ：表示like %v%
         * l: 表示 v%
         * :l 表示 %v
         * null 表示 is null
         * !null 表示 is not null
         */
        SimpleSpecificationBuilder<Book> simpleSpecificationBuilder=new SimpleSpecificationBuilder<>();
        if(!StringUtils.isEmpty(bookQuery.getBookName())){
            simpleSpecificationBuilder.and("bookName",":",bookQuery.getBookName());
        }
        if(!StringUtils.isEmpty(bookQuery.getBeginDate())){
            simpleSpecificationBuilder.and("grantStartTime","ge",bookQuery.getBeginDate());
        }
        if(!StringUtils.isEmpty(bookQuery.getEndDate())){
            simpleSpecificationBuilder.and("grantStartTime","lt",bookQuery.getEndDate());
        }
        Page page = bookDao.findAll(simpleSpecificationBuilder.getSpecification(), PageRequest.of(pageNo-1,pageSize));
        return page;

    }


}

