package com.mhc.orianna.core.biz;

import com.mhc.bs.common.base.APIResult;
import com.mhc.bs.common.base.page.PageInfo;
import com.mhc.orianna.api.AssetCatalogFacade;
import com.mhc.orianna.api.dto.AssetCatalogDTO;
import com.mhc.orianna.api.query.AssetCatalogQuery;
import com.mhc.orianna.api.query.BaseDubboRequest;
import com.mhc.orianna.core.biz.service.AssetCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: liuyi
 * @Date: 2018/12/1 7:57 PM
 * @Version 1.0
 */
@Service("assetCatalogFacade")
public class AssetCatalogFacadeImpl implements AssetCatalogFacade {

    @Autowired
    private AssetCatalogService assetCatalogService;

    @Override
    public APIResult<Boolean> addAssetCatalog(AssetCatalogDTO assetCatalogDTO){
        Boolean flag = assetCatalogService.addAssetCatalog(assetCatalogDTO);
        return APIResult.ok(flag);
    }
    @Override
    public APIResult<Boolean> deleteAssetCatalog(AssetCatalogDTO assetCatalogDTO){
        Boolean flag = assetCatalogService.deleteAssetCatalog(assetCatalogDTO);
        return APIResult.ok(flag);
    }

    @Override
    public APIResult<PageInfo<AssetCatalogDTO>> queryAssertCatalog(AssetCatalogQuery assetCatalogQuery) {
        PageInfo<AssetCatalogDTO> result = assetCatalogService.queryAssertCatalog(assetCatalogQuery);
        return APIResult.ok(result);
    }

    @Override
    public APIResult<Boolean> assetsWarehousing(){
        return APIResult.ok();
    }
}
