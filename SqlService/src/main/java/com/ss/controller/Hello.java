package com.ss.controller;

import com.ss.Service.Impl.TblmanagerMapperImpl;
import com.ss.Service.Impl.TbltypeMapperImpl;
import com.ss.bean.Tbltype;
import com.ss.mapper.TblmanagerMapper;
import com.ss.mapper.TbltypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Hello {
    @Autowired
    TbltypeMapperImpl tbltypeMapper;
    @Autowired
    TbltypeMapper tbltypemapper;
    @Autowired
    TblmanagerMapperImpl tbltypeMapperImpl;

    @CrossOrigin
    @RequestMapping("/select")
    public Tbltype select(){
        Tbltype tbltype = new Tbltype();
        tbltype.setGoodsTypeId(1234567891123456789L);
        Tbltype tbltype1 = tbltypemapper.selectById(tbltype);
        tbltype1.setStatus(null);
        return tbltype1;
    }
    @RequestMapping("/testSql")
    public String testSql(){
        tbltypeMapperImpl.testMmsql();
        return "sql";
    }
}
