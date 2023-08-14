package com.ss.Service.Impl;

import com.ss.bean.Tblmanager;
import com.ss.bean.Tbltype;
import com.ss.mapper.TblmanagerMapper;
import com.ss.mapper.TbltypeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Component
public class TbltypeMapperImpl {
    @Autowired
    TblmanagerMapperImpl tblmanagerMapper;
    @Autowired
    TbltypeMapper tbltypeMapper;
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
