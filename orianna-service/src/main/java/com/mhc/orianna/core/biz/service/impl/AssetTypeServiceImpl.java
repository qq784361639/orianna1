package com.mhc.orianna.core.biz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mhc.bs.common.base.page.PageInfo;
import com.mhc.orianna.api.dto.AssetTypeDTO;
import com.mhc.orianna.api.enums.AssetTypeStatusEnum;
import com.mhc.orianna.api.enums.IsDeletedEnum;
import com.mhc.orianna.api.query.BaseDubboRequest;
import com.mhc.orianna.core.base.config.util.BeanUtil;
import com.mhc.orianna.core.biz.service.AssetTypeService;
import com.mhc.orianna.dal.domain.AssetType;
import com.mhc.orianna.dal.manager.AssetTypeManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class AssetTypeServiceImpl implements AssetTypeService {
    @Autowired
    private AssetTypeManager assetTypeManager;
    @Override
    public Boolean addAssetType(AssetTypeDTO assetTypeDTO) throws Exception {
        Wrapper<AssetType> aw = new EntityWrapper<>();
        aw.eq("asset_type_name",assetTypeDTO.getAssetTypeName());
        aw.eq("asset_type_code",assetTypeDTO.getAssetTypeCode());
        List<AssetType> assetTypes = assetTypeManager.selectList(aw);
        if(assetTypes.size()>0){
            throw new Exception();
        }
        AssetType assetType = new AssetType();
        assetType.setAssetDescription(assetTypeDTO.getAssetTypeDescription());
        assetType.setAssetStatus(AssetTypeStatusEnum.ENABLE.getCode());
        assetType.setAssetTypeCode(assetTypeDTO.getAssetTypeCode());
        assetType.setIsDeleted(IsDeletedEnum.NOT_DELETE.getCode());
        assetType.setAssetTypeName(assetTypeDTO.getAssetTypeName());
        Date date = new Date();
        assetType.setGmtCreate(date);
        assetType.setGmtModified(date);
        Integer count = assetTypeManager.insert(assetType);
        if(count>0) {
            return true;
        }else{
            return false;
        }

    }

    @Override
    public Boolean updateAssetTypeStatus(AssetTypeDTO assetTypeDTO) {
        AssetType assetType = new AssetType();
        assetType.setAssetTypeId(assetTypeDTO.getAssetTypeId());
        Date date = new Date();
        assetType.setGmtModified(date);
        assetType.setAssetStatus(assetTypeDTO.getAssetTypeStatusEnum().getCode());
        Wrapper<AssetType> ew = new EntityWrapper<>();
        ew.eq("asset_type_id", assetTypeDTO.getAssetTypeId());
        Integer count = assetTypeManager.update(assetType,ew);
        if(count>0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteAssetType(AssetTypeDTO assetTypeDTO) {
        AssetType assetType = new AssetType();
        assetType.setIsDeleted(IsDeletedEnum.DELETE.getCode());
        Wrapper<AssetType> ew = new EntityWrapper<>();
        ew.eq("asset_type_id", assetTypeDTO.getAssetTypeId());
        Integer count = assetTypeManager.update(assetType,ew);
        if(count>0){
            return true;
        }
        return false;
    }



    @Override
    public PageInfo<AssetTypeDTO> queryAssetType(BaseDubboRequest baseDubboRequest) {
        Wrapper<AssetType> ew = new EntityWrapper<>();
        ew.eq("is_deleted",0);
        List<String> orderList = new ArrayList<>();
        orderList.add("gmt_modified");
        ew.orderDesc(orderList);
        AssetType assetType = new AssetType();
        Page<AssetType> page = assetTypeManager.selectPage(buildPage(baseDubboRequest),ew);
        return BeanUtil.convertPage2PageInfo(AssetTypeDTO.class,page,assetTypeConvert);
    }
    private final BeanUtil.IConvert<AssetTypeDTO, AssetType> assetTypeConvert = (dest, src) -> {
        dest.setAssetTypeDescription(src.getAssetDescription());
        dest.setAssetTypeCode(src.getAssetTypeCode());
        dest.setAssetTypeName(src.getAssetTypeName());
        dest.setAssetTypeStatusEnum(AssetTypeStatusEnum.getEnumByCode(src.getAssetStatus()));
        dest.setAssetTypeId(src.getAssetTypeId());
        dest.setIsDeletedEnum(IsDeletedEnum.getEnumByCode(src.getIsDeleted()));
    };

    private <T extends BaseDubboRequest> Page<AssetType> buildPage(T query) {
        Page<AssetType> page = new Page<>();
        page.setSize(query.getPageSize());
        page.setCurrent(query.getPageNo());
        return page;
    }

    @Override
    public List<AssetTypeDTO> queryAllAssetType() {
        Wrapper<AssetType> ew = new EntityWrapper<>();
        ew.eq("is_deleted",0).eq("asset_status",1);
        List<AssetType> list = assetTypeManager.selectList(ew);
        List<AssetTypeDTO> listdto = new ArrayList<>();
        AssetTypeDTO assetTypeDTO = null;
        for (AssetType assettype :list) {
            assetTypeDTO = new AssetTypeDTO();
            assetTypeDTO.setIsDeletedEnum(IsDeletedEnum.getEnumByCode(assettype.getIsDeleted()));
            assetTypeDTO.setAssetTypeId(assettype.getAssetTypeId());
            assetTypeDTO.setAssetTypeStatusEnum(AssetTypeStatusEnum.getEnumByCode(assettype.getAssetStatus()));
            assetTypeDTO.setAssetTypeName(assettype.getAssetTypeName());
            assetTypeDTO.setAssetTypeCode(assettype.getAssetTypeCode());
            assetTypeDTO.setAssetTypeDescription(assettype.getAssetDescription());
            listdto.add(assetTypeDTO);
        }
        return listdto;
    }
}
