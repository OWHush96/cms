package com.javakc.cms.book.controller;

import com.javakc.cms.book.entity.Book;
import com.javakc.cms.book.service.BookService;
import com.javakc.cms.book.vo.BookQuery;
import com.javakc.commonutils.api.APICODE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 书籍管理 -控制器
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description:书籍管理
 * @Date:2021/1/12 00129:19
 **/
@Api(tags="书籍管理")
@RestController
@RequestMapping("/cms/book")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation("查询所有书籍数据")
    @GetMapping
    public APICODE findAll(){
        // ## 调用service 的查询方法
        List<Book> booklist=bookService.findAll();
        return APICODE.OK().data("items",booklist);
    }

    @ApiOperation("根据条件进行分页查询 - 书籍管理")
    @PostMapping("{pageNo}/{pageSize}")
    public APICODE pageBook(BookQuery bookQuery, @PathVariable Integer pageNo, @PathVariable Integer pageSize ){
        //调用service中的分页进行查询
        Page<Book> page=bookService.pageBook(bookQuery, pageNo, pageSize);
        long totalElements =page.getTotalElements();
        List<Book> list=page.getContent();
        return APICODE.OK().data("total",totalElements).data("items",list);
    }

    @ApiOperation("添加书籍")
    @PostMapping("saveBook")
    public APICODE saveBook(@RequestBody Book book){
        bookService.saveOrUpdate(book);
        return APICODE.OK();
    }

    @ApiOperation("根据传入的id值删除书籍")
    @DeleteMapping("{bookId}")
    public APICODE deleteBook(Integer bookId){
        bookService.removeById(bookId);
        return APICODE.OK();
    }

    @ApiOperation("根据传入的id查询单条数据 - 书籍信息")
    @GetMapping("{bookId}")
    public APICODE view(Integer bookId){
        Book book=bookService.getById(bookId);
        return APICODE.OK().data("book",book);
    }

    @ApiOperation("修改书籍")
    @PutMapping("updateBook")
    public APICODE updateBook(@RequestBody Book book){
        bookService.saveOrUpdate(book);
        return APICODE.OK();
    }



}

