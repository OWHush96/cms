package com.javakc.copyright.copyr.service;

import com.javakc.commonutils.jpa.base.service.BaseService;
import com.javakc.copyright.copyr.dao.CopyrightDao;
import com.javakc.copyright.copyr.entity.Copyright;
import com.javakc.copyright.copyr.vo.QueryCopyright;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Program:javakc-parent
 * @Author:Administrator
 * @Description:
 * @Date:2021/1/15 001519:33
 **/
public class CopyrightService extends BaseService<CopyrightDao,String> {

    @Autowired
    private CopyrightDao copyrightDao;

    public List<Copyright> findAll(){
        List<Copyright> list=copyrightDao.findAll();
        return list;
    }

//    public Page<Copyright> pageCopyright(QueryCopyright copyright, int pageSize, int pageNo){
//
//    }


}

