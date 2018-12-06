package com.mhc.orianna.core.biz;

import com.mhc.bs.common.base.APIResult;
import com.mhc.bs.common.base.page.PageInfo;
import com.mhc.orianna.api.AssetTypeFacade;
import com.mhc.orianna.api.dto.AssetTypeDTO;
import com.mhc.orianna.api.query.BaseDubboRequest;
import com.mhc.orianna.core.biz.service.AssetTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("assetTypeFacade")
@Slf4j
public class AssetTypeFacadeImpl implements AssetTypeFacade {
    @Autowired
    AssetTypeService assetTypeService;
    @Override
    public APIResult<Boolean> addAssetType(AssetTypeDTO assetTypeDTO) {
        Boolean flag = null;
        try {
            flag = assetTypeService.addAssetType(assetTypeDTO);
        } catch (Exception e) {
            APIResult<Boolean> APIResult = new APIResult<>();
            APIResult.setMessage("该资产类型已存在，无法新增");
            APIResult.setSuccess(false);
            APIResult.setData(false);
            return APIResult;
        }
        return APIResult.ok(flag);
    }

    @Override
    public APIResult<Boolean> updateAssetTypeStatus(AssetTypeDTO assetTypeDTO) {
        Boolean flag = assetTypeService.updateAssetTypeStatus(assetTypeDTO);
        return APIResult.ok(flag);
    }

    @Override
    public APIResult<Boolean> deleteAssetType(AssetTypeDTO assetTypeDTO) {
        Boolean flag = assetTypeService.deleteAssetType(assetTypeDTO);
        return APIResult.ok(flag);
    }

    @Override
    public APIResult<PageInfo<AssetTypeDTO>> queryAssetType(BaseDubboRequest baseDubboRequest) {
        PageInfo<AssetTypeDTO> pageinfo = assetTypeService.queryAssetType(baseDubboRequest);
        return APIResult.ok(pageinfo);
    }

    @Override
    public APIResult<List<AssetTypeDTO>> queryAllAssertType(Boolean isAddCatalog) {
        List<AssetTypeDTO> list = assetTypeService.queryAllAssetType(isAddCatalog);
        return APIResult.ok(list);
    }
}
