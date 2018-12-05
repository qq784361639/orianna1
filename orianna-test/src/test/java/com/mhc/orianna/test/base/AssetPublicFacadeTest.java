package com.mhc.orianna.test.base;

import com.mhc.bs.common.base.APIResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: liuyi
 * @Date: 2018/12/5 3:10 PM
 * @Version 1.0
 */
public class AssetPublicFacadeTest extends BaseTest{
    @Autowired
    AssetPublicFacade assetPublicFacade;
    @Test
    public void test1(){
        APIResult allDepartmentName = assetPublicFacade.getAllDepartmentName();
        System.out.println(allDepartmentName.toString());
    }

    @Test
    public void test2(){
        APIResult allDepartmentName = assetPublicFacade.getDepartmentNameAndPositionByName("麦禾");
        System.out.println(allDepartmentName.toString());
    }
}