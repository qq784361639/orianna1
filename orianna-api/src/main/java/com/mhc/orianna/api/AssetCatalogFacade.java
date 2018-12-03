package com.mhc.orianna.api;

import com.mhc.bs.common.base.APIResult;
import com.mhc.bs.common.base.page.PageInfo;
import com.mhc.orianna.api.dto.AssetCatalogDTO;
import com.mhc.orianna.api.query.AssetCatalogQuery;
import com.mhc.orianna.api.query.BaseDubboRequest;

/**
 * 资产目录接口
 * @Author: liuyi
 * @Date: 2018/12/1 7:38 PM
 * @Version 1.0
 */
public interface AssetCatalogFacade {
    /**
     * 新增目录
     * @param assetCatalogDTO
     * @return APIResult<Integer>
     */
    APIResult<Boolean> addAssetCatalog(AssetCatalogDTO assetCatalogDTO);
    /**
     * 删除目录 （逻辑删除
     * @param assetCatalogDTO
     * @return APIResult<Boolean>
     */
    APIResult<Boolean> deleteAssetCatalog(AssetCatalogDTO assetCatalogDTO);
    /**
     * 条件查询目录
     * @param assetCatalogQuery
     * @return APIResult<PageInfo<AssetCatalogDTO>>
     */
    APIResult<PageInfo<AssetCatalogDTO>> queryAssertCatalog(AssetCatalogQuery assetCatalogQuery);
    /**
     * 资产入库
     * @param
     * @return APIResult<Boolean>
     */
    APIResult<Boolean> assetsWarehousing();
}