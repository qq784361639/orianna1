package com.mhc.orianna.api;

import com.mhc.bs.common.base.APIResult;
import com.mhc.bs.common.base.page.PageInfo;
import com.mhc.orianna.api.dto.AssetDTO;
import com.mhc.orianna.api.dto.ReturnRecordDTO;
import com.mhc.orianna.api.query.AssetQuery;

/**
 * 资产接口
 */
public interface AssetFacade {
    /**
     * 资产入库
     * @param assetDTO
     * @return
     */
    APIResult<Boolean> assetStorage(AssetDTO assetDTO);

    /**
     * 领用入库
     */
    APIResult<Boolean> borrowAsset(AssetDTO assetDTO);

    /**
     * 归还
     */
    APIResult<Boolean> returnAsset(ReturnRecordDTO returnRecordDTO);

    /**
     * 退租
     */
    APIResult<Boolean> withdrawal(AssetDTO assetDTO);

    /**
     * 单个查询
     */
    APIResult<AssetDTO> selectOneById(Integer assetId);

    /**
     * 编辑资产信息
     */
    APIResult<Boolean> updateAsset(AssetDTO assetDTO);

    /**
     * 多条件查询资产信息列表
     */
    APIResult<PageInfo<AssetDTO>> queryAsset(AssetQuery assetQuery);
}

