package com.mhc.orianna.core.biz.service.impl;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mhc.bs.common.base.page.PageInfo;
import com.mhc.orianna.api.dto.AssetDTO;
import com.mhc.orianna.api.dto.ReturnRecordDTO;
import com.mhc.orianna.api.enums.*;
import com.mhc.orianna.api.query.AssetQuery;
import com.mhc.orianna.api.query.BaseDubboRequest;
import com.mhc.orianna.core.base.config.util.BeanUtil;
import com.mhc.orianna.core.biz.service.AssetService;
import com.mhc.orianna.dal.dao.AssetDao;
import com.mhc.orianna.dal.domain.*;
import com.mhc.orianna.dal.manager.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.sourceforge.pinyin4j.PinyinHelper;

@Service
@Slf4j
public class AssetServiceImpl implements AssetService {
    @Autowired
    private AssetManager assetManager;
    @Autowired
    private AssetCatalogManager assetCatalogManager;
    @Autowired
    private StoreRecordManager storeRecordManager;
    @Autowired
    private BorrowRecordManager borrowRecordManager;
    @Autowired
    private ReturnRecordManager returnRecordManager;
    @Autowired
    private AssetDao assetDao;
    @Override
    public Boolean insertAsset(AssetDTO assetDTO) {
        //增加资产
        Asset asset = new Asset();
        asset.setCatalogId(assetDTO.getCatalogId());
        Wrapper<AssetCatalog> aw = new EntityWrapper<>();
        aw.eq("catalog_id",assetDTO.getCatalogId());
        AssetCatalog assetCatalog = assetCatalogManager.selectOne(aw);
        asset.setCatalogBrand(assetCatalog.getCatalogBrand());
        asset.setCatalogModel(assetCatalog.getCatalogModel());
        asset.setAssetTypeName(assetCatalog.getAssetTypeName());
        asset.setAssetSource(assetDTO.getAssetSourceEnum().getCode());
        asset.setAssetOriginalValue(assetDTO.getAssetOriginalValue());
        asset.setAssetPurchaseOrRentDate(assetDTO.getAssetPurchaseOrRentDate());
        asset.setAssetStartDate(assetDTO.getAssetStartDate());
        asset.setAssetRemark(assetDTO.getAssetRemark());
        asset.setAssetSupplier(assetDTO.getAssetSupplier());
        Date date = new Date();
        asset.setAssetStatus(0);
        asset.setIsDeleted(0);
        asset.setGmtCreate(date);
        asset.setGmtModified(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String datestr = sdf.format(date);
        //增加入库记录
        StoreRecord storeRecord = new StoreRecord();
        storeRecord.setGmtCreate(date);
        storeRecord.setGmtModified(date);
        storeRecord.setStoreDate(date);
        storeRecord.setStoreRemark("");
        if(asset.getAssetSource()==0){
            asset.setAssetRentEndDate(assetDTO.getAssetRentEndDate());
        }
        Integer count = 0;
        if(assetDTO.getAssetSerialNo()==null && assetDTO.getAssetSerialNo().equals("")){
            return false;
        }
        String[] assetSerialNoArray = assetDTO.getAssetSerialNo().split(",");
        for (int i = 0; i < assetSerialNoArray.length; i++) {
            int no = i + 1;
            asset.setAssetSerialNo(assetSerialNoArray[i]);
            asset.setAssetNo(this.getPinYinHeadChar(assetCatalog.getAssetTypeName()).toUpperCase()+datestr+no);
            storeRecord.setAssetNo(asset.getAssetNo());
            count = count + assetManager.insert(asset);
            Wrapper<Asset> ew = new EntityWrapper<>();
            ew.eq("asset_no",asset.getAssetNo());
            Integer assetId = (Integer) assetManager.selectObj(ew);
            storeRecord.setAssetId(assetId);
            storeRecordManager.insert(storeRecord);
        }
        if(count>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean borrowAsset(AssetDTO assetDTO) {
        //填写资产信息
        Asset asset = new Asset();
        asset.setBorrowApprovalNo(assetDTO.getBorrowApprovalNo());
        asset.setAssetFlowType(assetDTO.getAssetFlowTypeEnum().getCode());
        asset.setAssetBorrowDate(assetDTO.getAssetBorrowDate());
        asset.setAuthStaffId(assetDTO.getAuthStaffId());
        asset.setAuthStaffName(assetDTO.getAuthStaffName());
        asset.setAuthStaffDept(assetDTO.getAuthStaffDept());
        asset.setAuthStaffJob(assetDTO.getAuthStaffJob());
        asset.setAssetPredictReturnDate(assetDTO.getAssetPredictReturnDate());
        asset.setAssetStatus(AssetStatusEnum.ISSUE.getCode());
        Date date = new Date();
        asset.setGmtModified(date);
        //填写领用记录信息
        BorrowRecord borrowRecord = new BorrowRecord();
        borrowRecord.setAssetFlowType(assetDTO.getAssetFlowTypeEnum().getCode());
        borrowRecord.setAuthStaffId(assetDTO.getAuthStaffId());
        borrowRecord.setAuthStaffName(assetDTO.getAuthStaffName());
        borrowRecord.setGmtCreate(date);
        borrowRecord.setGmtModified(date);
        borrowRecord.setBorrowDate(assetDTO.getAssetBorrowDate());
        borrowRecord.setBorrowRemark(assetDTO.getAssetRemark());
        borrowRecord.setBorrowApprovalNo(assetDTO.getBorrowApprovalNo());
        if(assetDTO.getAssetNo()==null && assetDTO.getAssetNo().equals("")){
            return false;
        }
        String[] assetNoArray = assetDTO.getAssetNo().split(",");
        try{
            for (int i = 0; i < assetNoArray.length; i++) {
                Wrapper<Asset> ew = new EntityWrapper<>();
                ew.eq("asset_no",assetNoArray[i]);
                assetManager.update(asset,ew);
                Integer assetId = (Integer)assetManager.selectObj(ew);
                borrowRecord.setAssetId(assetId);
                borrowRecord.setAssetNo(assetNoArray[i]);
                borrowRecordManager.insert(borrowRecord);
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Boolean returnAsset(ReturnRecordDTO returnRecordDTO) {
        //判断资产是否是已发放状态，不是直接返回false
        Wrapper<Asset> aw = new EntityWrapper<>();
        aw.eq("asset_id",returnRecordDTO.getAssetId());
        Asset asset1 = assetManager.selectOne(aw);
        if(asset1.getAssetStatus()!=1){
            return false;
        }
        returnRecordDTO.setAssetNo(asset1.getAssetNo());
        Date date = new Date();
        //填写归还资产信息
        Asset asset = new Asset();
        asset.setGmtModified(date);
        asset.setAssetStatus(0);
        asset.setAssetFlowType(0);
        //声明一个无意义的时间
        Date date1 = new Date();
        asset.setBorrowApprovalNo("");
        asset.setAuthStaffId(0);
        asset.setAuthStaffName("");
        asset.setAuthStaffJob("");
        asset.setAuthStaffDept("");
        Wrapper<Asset> ew = new EntityWrapper<>();
        ew.eq("asset_no",returnRecordDTO.getAssetNo());
        //填写归还记录信息
        ReturnRecord returnRecord = new ReturnRecord();
        returnRecord.setAssetId(returnRecordDTO.getAssetId());
        returnRecord.setAssetNo(returnRecordDTO.getAssetNo());
        returnRecord.setGmtCreate(date);
        returnRecord.setGmtModified(date);
        returnRecord.setReturnDate(returnRecordDTO.getReturnDate());
        returnRecord.setReturnRemark(returnRecordDTO.getReturnRemark());
        //领用时间和预计归还时间都为空
        assetDao.updateNullDateOnBorrowDateAndReturnDate(returnRecordDTO.getAssetNo());
        assetManager.update(asset,ew);
        int count = returnRecordManager.insert(returnRecord);
        if(count > 0 ){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean withdrawal(AssetDTO assetDTO) {
        Wrapper<Asset> ew = new EntityWrapper<>();
        ew.eq("asset_no",assetDTO.getAssetNo());
        Asset asset = assetManager.selectOne(ew);
        //判断资产状态，如果是已发放或者是已退租，不允许退租资产，返回false
        if(asset.getAssetStatus()==2 || asset.getAssetStatus()==1){
            return false;
        }
        Asset updateAsset = new Asset();
        updateAsset.setAssetStatus(2);
        updateAsset.setAssetBackRentDate(assetDTO.getAssetBackRentDate());
        updateAsset.setAssetBackRentRecord(assetDTO.getAssetBackRentRecord());
        Integer count = assetManager.update(updateAsset,ew);
        if(count > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public AssetDTO selectOneById(Integer assetId) {
        Wrapper<Asset> ew = new EntityWrapper<>();
        ew.eq("asset_id",assetId);
        Asset asset = assetManager.selectOne(ew);
        return BeanUtil.copyPorp2DO(AssetDTO.class,asset,assetConvert);

    }

    @Override
    public Boolean updateAsset(AssetDTO assetDTO) {
        Wrapper<Asset> ew = new EntityWrapper<>();
        ew.eq("asset_no",assetDTO.getAssetNo());
        Asset panduan = assetManager.selectOne(ew);
        //判断资产状态是否为已退租状态，如果是，返回false;
        if(panduan.getAssetStatus()==2){
            return false;
        }
        Asset asset = new Asset();
        asset.setAssetSource(assetDTO.getAssetSourceEnum().getCode());
        asset.setAssetOriginalValue(assetDTO.getAssetOriginalValue());
        asset.setAssetSupplier(assetDTO.getAssetSupplier());
        asset.setAssetPurchaseOrRentDate(assetDTO.getAssetPurchaseOrRentDate());
        asset.setAssetStartDate(assetDTO.getAssetStartDate());
        asset.setAssetRentEndDate(assetDTO.getAssetRentEndDate());
        asset.setAssetSerialNo(assetDTO.getAssetSerialNo());
        Integer count = assetManager.update(asset,ew);
        if(count > 0 ){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public PageInfo<AssetDTO> selectPage(AssetQuery assetQuery) {
        Wrapper<Asset> ew = new EntityWrapper<>();
        Integer assetFlowType = assetQuery.getAssetFlowType();
        String assetNo = assetQuery.getAssetNo();
        Integer assetSource = assetQuery.getAssetSource();
        Integer assetStatus = assetQuery.getAssetStatus();
        String assetSupplier = assetQuery.getAssetSupplier();
        String assetTypeName = assetQuery.getAssetTypeName();
        String authStaffDept = assetQuery.getAuthStaffDept();
        String authStaffName = assetQuery.getAuthStaffName();
        if(assetFlowType!=null){
            ew.eq("asset_flow_type",assetFlowType);
        }
        if(assetNo!=null && !assetNo.equals("")){
            ew.eq("asset_no",assetNo);
        }
        if(assetSource!=null){
            ew.eq("asset_source",assetSource);
        }
        if(assetStatus!=null){
            ew.eq("asset_status",assetStatus);
        }
        if(assetSupplier!=null && !assetSupplier.equals("")){
            ew.like("asset_supplier",assetSupplier);
        }
        if(assetTypeName!=null && !assetTypeName.equals("")){
            ew.eq("asset_type_name",assetTypeName);
        }
        if(authStaffDept!=null && !authStaffDept.equals("")){
            ew.eq("auth_staff_dept",authStaffDept);
        }
        if(authStaffName!=null && !authStaffName.equals("")){
            ew.eq("auth_staff_name",authStaffName);
        }
        Page<Asset> result = assetManager.selectPage(buildPage(assetQuery),ew);

        if (result == null || CollectionUtils.isEmpty(result.getRecords())) {
            return new PageInfo<>();
        }
        return BeanUtil.convertPage2PageInfo(AssetDTO.class, result, assetConvert);
    }

    private <T extends BaseDubboRequest> Page<Asset> buildPage(T query) {
        Page<Asset> page = new Page<>();
        page.setSize(query.getPageSize());
        page.setCurrent(query.getPageNo());
        return page;
    }

    private final BeanUtil.IConvert<AssetDTO, Asset> assetConvert = (dest, src) -> {
        dest.setAssetId(src.getAssetId());
        dest.setAssetNo(src.getAssetNo());
        dest.setCatalogId(src.getCatalogId());
        dest.setCatalogModel(src.getCatalogModel());
        dest.setAssetTypeName(src.getAssetTypeName());
        dest.setAssetTypeNo(src.getAssetNo());
        dest.setCatalogBrand(src.getCatalogBrand());
        dest.setAssetRemark(src.getAssetRemark());
        dest.setAssetSourceEnum(AssetSourceEnum.getEnumByCode(src.getAssetSource()));
        dest.setAssetSerialNo(src.getAssetSerialNo());
        dest.setAssetSupplier(src.getAssetSupplier());
        dest.setAssetPurchaseOrRentDate(src.getAssetPurchaseOrRentDate());
        dest.setAssetRentEndDate(src.getAssetRentEndDate());
        dest.setAssetStartDate(src.getAssetStartDate());
        dest.setAssetStatusEnum(AssetStatusEnum.getEnumByCode(src.getAssetStatus()));
        dest.setAssetFlowTypeEnum(AssetFlowTypeEnum.getEnumByCode(src.getAssetFlowType()));
        dest.setAssetBorrowDate(src.getAssetBorrowDate());
        dest.setAssetPredictReturnDate(src.getAssetPredictReturnDate());
        dest.setAssetOriginalValue(src.getAssetOriginalValue());
        dest.setBorrowApprovalNo(src.getBorrowApprovalNo());
        dest.setAuthStaffId(src.getAuthStaffId());
        dest.setAuthStaffName(src.getAuthStaffName());
        dest.setAuthStaffDept(src.getAuthStaffDept());
        dest.setAuthStaffJob(src.getAuthStaffJob());
        dest.setAssetBackRentDate(src.getAssetBackRentDate());
        dest.setAssetBackRentRecord(src.getAssetBackRentRecord());
        dest.setIsDeletedEnum(IsDeletedEnum.getEnumByCode(src.getIsDeleted()));
    };

    private   String getPinYinHeadChar(String str) {
        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert;
    }
}
