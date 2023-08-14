package com.csv.Service.Impl;

import com.csv.Service.Interfaces.CallStService;
import com.csv.bean.Tbltype;
//import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class CallStServiceConfig{


}
/*public class CallStServiceConfig  implements FallbackFactory<CallStService> {

    @Override
    public CallStService create(Throwable throwable) {
        return new CallStService() {
            @Override
            public Tbltype SayHello() {
                Tbltype tbltype = new Tbltype();//tbltype.setTypeName("feign sorry");
                tbltype.setParentId(61L);
                return tbltype;
            }
        };
    }
    }*/

