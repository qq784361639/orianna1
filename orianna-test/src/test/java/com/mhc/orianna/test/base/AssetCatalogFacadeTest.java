package com.mhc.orianna.test.base;

import com.mhc.bs.common.base.APIResult;
import com.mhc.orianna.api.AssetCatalogFacade;
import com.mhc.orianna.api.dto.AssetCatalogDTO;
import com.mhc.orianna.api.enums.IsDeletedEnum;
import com.mhc.orianna.api.query.AssetCatalogQuery;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: liuyi
 * @Date: 2018/12/1 7:53 PM
 * @Version 1.0
 */
public class AssetCatalogFacadeTest extends BaseTest {
    @Autowired
    private AssetCatalogFacade assetCatalogFacade;

    @Test
    public void testInsert(){

        AssetCatalogDTO assetCatalogDTO = new AssetCatalogDTO();
        assetCatalogDTO.setAssetCatalogNum("ML002");
        assetCatalogDTO.setAssetTypeName("手机");
        assetCatalogDTO.setAssetCatalogBrand("小米");
        assetCatalogDTO.setAssetCAtalogModel("mi8");
        assetCatalogDTO.setAssetCatalogRemark("测试数据");
        assetCatalogDTO.setIsDeletedEnum(IsDeletedEnum.not_delete);
        APIResult apiResult = new APIResult();
        apiResult = assetCatalogFacade.addAssetCatalog(assetCatalogDTO);
        System.out.println(apiResult.toString());
    }

    @Test
    public void testDelete(){

        AssetCatalogDTO assetCatalogDTO = new AssetCatalogDTO();
        assetCatalogDTO.setAssetCatalogId(1);
        assetCatalogDTO.setIsDeletedEnum(IsDeletedEnum.delete);
        APIResult apiResult = assetCatalogFacade.deleteAssetCatalog(assetCatalogDTO);
        System.out.println(apiResult.toString());
    }

    @Test
    public void testQuery(){
        AssetCatalogQuery assetCatalogQuery = new AssetCatalogQuery();
        assetCatalogQuery.setAssetTypeName("笔记本");
        APIResult apiResult = assetCatalogFacade.queryAssertCatalog(assetCatalogQuery);
        System.out.println(apiResult.toString());
    }
}
