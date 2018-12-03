package com.mhc.orianna.test.base;

import com.mhc.bs.common.base.APIResult;
import com.mhc.orianna.api.AssetFacade;
import com.mhc.orianna.api.AssetTypeFacade;
import com.mhc.orianna.api.dto.AssetDTO;
import com.mhc.orianna.api.dto.AssetTypeDTO;
import com.mhc.orianna.api.dto.ReturnRecordDTO;
import com.mhc.orianna.api.enums.*;
import com.mhc.orianna.api.query.AssetQuery;
import com.mhc.orianna.api.query.BaseDubboRequest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

public class DemoFacadeTest extends BaseTest {
    @Autowired
    AssetTypeFacade assetTypeFacade;
    @Autowired
    AssetFacade assetFacade;

    @Test
    public void test1(){
        AssetTypeDTO assetTypeDTO = new AssetTypeDTO();
        assetTypeDTO.setAssetTypeDescription("11");
        assetTypeDTO.setAssetTypeStatusEnum(AssetTypeStatusEnum.enable);
        assetTypeDTO.setAssetTypeCode("22");
        assetTypeDTO.setAssetTypeName("笔记本");
        assetTypeDTO.setIsDeletedEnum(IsDeletedEnum.not_delete);
        APIResult apiResult;
        apiResult = assetTypeFacade.addAssetType(assetTypeDTO);
        System.out.print(apiResult.toString());

    }

    @Test
    public void test2(){
        AssetTypeDTO assetTypeDTO = new AssetTypeDTO();
        assetTypeDTO.setAssetTypeId(1);
        assetTypeDTO.setAssetTypeStatusEnum(AssetTypeStatusEnum.dsiable);
        APIResult apiResult = assetTypeFacade.updateAssetTypeStatus(assetTypeDTO);
        System.out.print(apiResult.toString());

    }

    @Test
    public void test3(){
        AssetTypeDTO assetTypeDTO = new AssetTypeDTO();
        assetTypeDTO.setAssetTypeId(1);
        assetTypeDTO.setIsDeletedEnum(IsDeletedEnum.delete);
        APIResult apiResult = assetTypeFacade.deleteAssetType(assetTypeDTO);
        System.out.print(apiResult.toString());

    }

    @Test
    public void test4(){
        AssetTypeDTO assetTypeDTO = new AssetTypeDTO();
        assetTypeDTO.setAssetTypeId(1);
        assetTypeDTO.setIsDeletedEnum(IsDeletedEnum.delete);
        APIResult apiResult = assetTypeFacade.queryAllAssertType();
        System.out.print(apiResult.toString());

    }

    @Test
    public void test5(){
        BaseDubboRequest baseDubboRequest = new BaseDubboRequest();
        baseDubboRequest.setPageNo(2);
        baseDubboRequest.setPageSize(10);
        APIResult apiResult = assetTypeFacade.queryAssetType(baseDubboRequest);
        System.out.print(apiResult.toString());

    }

    @Test
    public void test6(){
        AssetDTO assetDTO = new AssetDTO();
        assetDTO.setAssetOriginalValue(new BigDecimal(5000));
        Date date = new Date();
        assetDTO.setAssetPurchaseOrRentDate(date);
        assetDTO.setCatalogId(1);
        assetDTO.setCatalogBrand("苹果");
        assetDTO.setCatalogModel("macbook pro");
        assetDTO.setAssetTypeName("笔记本");
        assetDTO.setAssetTypeNo("BJB");
        assetDTO.setAssetSupplier("苹果公司");
        assetDTO.setAssetSourceEnum(AssetSourceEnum.company_asset);
        assetDTO.setAssetStartDate(date);
        assetDTO.setAssetRemark("");
        assetDTO.setAssetSerialNo("123DA757RT,8628HFH868,857HVBJ231");
        assetDTO.setAssetRentEndDate(date);
        APIResult apiResult = assetFacade.assetStorage(assetDTO);
        System.out.print(apiResult.toString());
    }

    @Test
    public void test7(){
        AssetDTO assetDTO = new AssetDTO();
        Date date = new Date();
        assetDTO.setBorrowApprovalNo("GJGI879819");
        assetDTO.setAssetFlowTypeEnum(AssetFlowTypeEnum.asset_borrow);
        assetDTO.setAssetBorrowDate(date);
        assetDTO.setAuthStaffId(520);
        assetDTO.setAssetPredictReturnDate(date);
        assetDTO.setAuthStaffName("维桢");
        assetDTO.setAuthStaffDept("产品技术部");
        assetDTO.setAuthStaffJob("实习生");
        assetDTO.setAssetRemark("电源3个，鼠标3个");
        assetDTO.setAssetNo("BJB201812021157483,BJB201812020726531");
        APIResult apiResult = assetFacade.borrowAsset(assetDTO);
        System.out.print(apiResult.toString());

    }

    @Test
    public void test8(){
        Date date = new Date();
        ReturnRecordDTO returnRecordDTO = new ReturnRecordDTO();
        returnRecordDTO.setAssetId(1);
        returnRecordDTO.setAssetNo("BJB201812020726531");
        returnRecordDTO.setAssetStatusEnum(AssetStatusEnum.issue);
        returnRecordDTO.setReturnDate(date);
        returnRecordDTO.setReturnRemark("已归还");
        APIResult apiResult = assetFacade.returnAsset(returnRecordDTO);
        System.out.print(apiResult.toString());
    }

    @Test
    public void test9(){
        AssetDTO assetDTO = new AssetDTO();
        assetDTO.setAssetNo("BJB201812021157481");
        Date date = new Date();
        assetDTO.setAssetBackRentDate(date);
        assetDTO.setAssetBackRentRecord("资产已退租");
        APIResult apiResult = assetFacade.withdrawal(assetDTO);
        System.out.print(apiResult.toString());
    }

    @Test
    public void test10(){
        Integer assetid = 4;
        APIResult apiResult = assetFacade.selectOneById(assetid);
        System.out.print(apiResult.toString());
    }

    @Test
    public void test11(){
        AssetDTO assetDTO = new AssetDTO();
        assetDTO.setAssetNo("BJB201812021157482");
        assetDTO.setAssetSourceEnum(AssetSourceEnum.rent_asset);
        Date date = new Date();
        assetDTO.setAssetPurchaseOrRentDate(date);
        assetDTO.setAssetSupplier("苹果代理商");
        assetDTO.setAssetRentEndDate(date);
        APIResult apiResult = assetFacade.updateAsset(assetDTO);
        System.out.print(apiResult.toString());
    }

    @Test
    public void test12(){
        AssetQuery assetQuery = new AssetQuery();
        assetQuery.setPageSize(5);
//        assetQuery.setAssetStatus(0);
//        assetQuery.setAssetSource(0);
        APIResult apiResult = assetFacade.queryAsset(assetQuery);
        System.out.print(apiResult.toString());
    }
}
