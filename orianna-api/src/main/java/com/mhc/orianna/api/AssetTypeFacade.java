package com.mhc.orianna.api;

import com.mhc.bs.common.base.APIResult;
import com.mhc.bs.common.base.page.PageInfo;
import com.mhc.orianna.api.dto.AssetTypeDTO;
import com.mhc.orianna.api.query.BaseDubboRequest;

import java.util.List;

/**
 * 资产类型接口
 */
public interface AssetTypeFacade {
    /**
     * 新增资产类型
     * @return
     */
    APIResult<Boolean> addAssetType(AssetTypeDTO assetTypeDTO);
    /**
     * 更新状态：停启用
     */
    APIResult<Boolean> updateAssetTypeStatus(AssetTypeDTO assetTypeDTO);

    /**
     * 逻辑删除资产类型
     */
    APIResult<Boolean> deleteAssetType(AssetTypeDTO assetTypeDTO);

    /**
     * 查询资产类型信息
     * @return
     */
    APIResult<PageInfo<AssetTypeDTO>> queryAssetType(BaseDubboRequest baseDubboRequest);

    /**
     * 查询所有未删除，已启用的资产类型信息
     */
    APIResult<List<AssetTypeDTO>> queryAllAssertType();

}
