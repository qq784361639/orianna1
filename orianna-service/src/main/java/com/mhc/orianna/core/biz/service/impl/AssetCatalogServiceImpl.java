package com.mhc.orianna.core.biz.service.impl;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mhc.bs.common.base.page.PageInfo;
import com.mhc.orianna.api.dto.AssetCatalogDTO;
import com.mhc.orianna.api.enums.IsDeletedEnum;
import com.mhc.orianna.api.query.AssetCatalogQuery;
import com.mhc.orianna.api.query.BaseDubboRequest;
import com.mhc.orianna.core.base.config.util.BeanUtil;
import com.mhc.orianna.core.biz.service.AssetCatalogService;
import com.mhc.orianna.dal.domain.AssetCatalog;
import com.mhc.orianna.dal.manager.AssetCatalogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: liuyi
 * @Date: 2018/12/1 8:30 PM
 * @Version 1.0
 */
@Service
public class AssetCatalogServiceImpl implements AssetCatalogService {

    @Autowired
    private AssetCatalogManager assetCatalogManager;
    /**
     * 新增目录
     */
    @Override
   public Boolean addAssetCatalog(AssetCatalogDTO assetCatalogDTO){
        AssetCatalog assetCatalog = new AssetCatalog();
        assetCatalog.setCatalogId(assetCatalogDTO.getAssetCatalogId());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        assetCatalog.setCatalogNum("ML"+sdf.format(date));
        assetCatalog.setAssetTypeName(assetCatalogDTO.getAssetTypeName());
        assetCatalog.setCatalogBrand(assetCatalogDTO.getAssetCatalogBrand());
        assetCatalog.setCatalogModel(assetCatalogDTO.getAssetCatalogModel());
        assetCatalog.setCatalogRemark(assetCatalogDTO.getAssetCatalogRemark());
        assetCatalog.setIsDeleted(IsDeletedEnum.NOT_DELETE.getCode());
        assetCatalog.setGmtCreate(date);
        assetCatalog.setGmtModified(date);
        Integer flag = assetCatalogManager.insert(assetCatalog);
        if(flag == 1){
            return true;
        }else {
            return false;
        }
    }
    /**
     * 删除目录 （逻辑删除
     */
    @Override
    public Boolean deleteAssetCatalog(AssetCatalogDTO assetCatalogDTO){
        AssetCatalog assetCatalog = new AssetCatalog();
        assetCatalog.setIsDeleted(IsDeletedEnum.DELETE.getCode());
        Wrapper<AssetCatalog> ew = new EntityWrapper<>();
        ew.eq("catalog_id", assetCatalogDTO.getAssetCatalogId());
        Integer flag = assetCatalogManager.update(assetCatalog,ew);
        if(flag>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 条件查询目录
     */
    @Override
    public PageInfo<AssetCatalogDTO> queryAssertCatalog(AssetCatalogQuery assetCatalogQuery) {
        String assetTypeName = assetCatalogQuery.getAssetTypeName();
        String catalogBrand = assetCatalogQuery.getCatalogBrand();
        String catalogModel = assetCatalogQuery.getCatalogModel();
        String catalogNum = assetCatalogQuery.getCatalogNum();
        Wrapper<AssetCatalog> ew = new EntityWrapper<>();
        if(assetTypeName!=null && !assetTypeName.equals("")){
            ew.eq("asset_type_name",assetTypeName);
        }
        if(catalogBrand!=null && !catalogBrand.equals("")){
            ew.like("catalog_brand",catalogBrand);
        }
        if(catalogModel!=null && !catalogModel.equals("")){
            ew.like("catalog_model",catalogModel);
        }
        if(catalogNum!=null && !catalogNum.equals("")){
            ew.like("catalog_num",catalogNum);
        }
        ew.eq("is_deleted",0);
        Page<AssetCatalog> result = assetCatalogManager.selectPage(buildPage(assetCatalogQuery),ew);
        if (result == null || CollectionUtils.isEmpty(result.getRecords())) {
            return new PageInfo<>();
        }
        return BeanUtil.convertPage2PageInfo(AssetCatalogDTO.class, result, assetCatalogConvert);


    }
    private <T extends BaseDubboRequest> Page<AssetCatalog> buildPage(T query) {
        Page<AssetCatalog> page = new Page<>();
        page.setSize(query.getPageSize());
        page.setCurrent(query.getPageNo());
        return page;
    }
    private final BeanUtil.IConvert<AssetCatalogDTO, AssetCatalog> assetCatalogConvert = (dest, src) -> {
        dest.setAssetCatalogId(src.getCatalogId());
        dest.setIsDeletedEnum(IsDeletedEnum.getEnumByCode(src.getIsDeleted()));
        dest.setAssetCatalogRemark(src.getCatalogRemark());
        dest.setAssetCatalogModel(src.getCatalogModel());
        dest.setAssetCatalogBrand(src.getCatalogBrand());
        dest.setAssetTypeName(src.getAssetTypeName());
        dest.setAssetCatalogNum(src.getCatalogNum());
    };

}







