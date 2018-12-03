package com.mhc.orianna.core.biz.service;

import com.mhc.bs.common.base.page.PageInfo;
import com.mhc.framework.common.base.biz.BaseService;
import com.mhc.orianna.api.dto.AssetCatalogDTO;
import com.mhc.orianna.api.query.AssetCatalogQuery;
import com.mhc.orianna.api.query.BaseDubboRequest;

/**
 * @Author: liuyi
 * @Date: 2018/12/1 8:26 PM
 * @Version 1.0
 */
public interface AssetCatalogService extends BaseService {
    /**
     * 新增目录
     */
    Boolean addAssetCatalog(AssetCatalogDTO assetCatalogDTO);
    /**
     * 删除目录 （逻辑删除
     */
    Boolean deleteAssetCatalog(AssetCatalogDTO assetCatalogDTO);
    /**
     * 条件查询目录
     */
//    PageInfo<AssetCatalogDTO> queryAssertCatalog(BaseDubboRequest baseDubboRequest);


    PageInfo<AssetCatalogDTO> queryAssertCatalog(AssetCatalogQuery assetCatalogQuery);
}
