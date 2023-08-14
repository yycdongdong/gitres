package com.ss.Service.Impl;

import com.ss.bean.Tblmanager;
import com.ss.bean.Tbltype;
import com.ss.mapper.TblmanagerMapper;
import com.ss.mapper.TbltypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Component
public class TblmanagerMapperImpl {

    @Autowired
    TblmanagerMapper tblmanagerMapper;
    @Autowired
    TbltypeMapperImpl tbltypeMapperImpl;
    @Autowired
    TbltypeMapper tbltypeMapper;
    //Transactional
    public void testMmsql(){
        Tblmanager tblmanager = new Tblmanager();
        tblmanager.setVersion(6);
        tblmanager.setManagerAcc("rk");
        tblmanager.setStatus(6L);
        tblmanager.setManagerPwd("123456");
        tblmanager.setRealName("rkch");
        tblmanagerMapper.insert(tblmanager);
        // testTypeSql();
        tbltypeMapperImpl.testTypeSql();
    }
    @Transactional
    public void testTypeSql(){
        Tbltype tbltype = new Tbltype();
        tbltype.setTypeName("rk");
        tbltype.setParentId(61L);
        tbltype.setStatus(6L);
        tbltypeMapper.insert(tbltype);
        System.out.println(2/0);
    }

}