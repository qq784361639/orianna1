package com.mhc.orianna.core.biz.service;

import com.mhc.bs.common.base.page.PageInfo;
import com.mhc.orianna.api.dto.AssetTypeDTO;
import com.mhc.orianna.api.query.BaseDubboRequest;

import java.util.List;

public interface AssetTypeService {
    Boolean addAssetType(AssetTypeDTO assetTypeDTO);

    Boolean updateAssetTypeStatus(AssetTypeDTO assetTypeDTO);

    Boolean deleteAssetType(AssetTypeDTO assetTypeDTO);

    PageInfo<AssetTypeDTO> queryAssetType(BaseDubboRequest baseDubboRequest);

    List<AssetTypeDTO> queryAllAssetType();
}
