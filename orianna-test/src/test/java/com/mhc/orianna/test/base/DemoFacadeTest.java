package com.mhc.orianna.test.base;

import com.mhc.bs.common.base.APIResult;
import com.mhc.orianna.api.DemoFacade;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoFacadeTest extends BaseTest {

    @Autowired
    private DemoFacade demoFacade;

    @Test
    public void test1(){
        APIResult result = demoFacade.hello("aaa");
        System.out.println();

    }
}
