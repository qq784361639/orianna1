package com.mhc.orianna.core.biz.service;

import com.mhc.bs.common.base.page.PageInfo;
import com.mhc.orianna.api.dto.AssetDTO;
import com.mhc.orianna.api.dto.ReturnRecordDTO;
import com.mhc.orianna.api.query.AssetQuery;

public interface AssetService {
    Boolean insertAsset(AssetDTO assetDTO);

    Boolean borrowAsset(AssetDTO assetDTO);

    Boolean returnAsset(ReturnRecordDTO returnRecordDTO);

    Boolean withdrawal(AssetDTO assetDTO);

    AssetDTO selectOneById(Integer assetId);

    Boolean updateAsset(AssetDTO assetDTO);

    PageInfo<AssetDTO> selectPage(AssetQuery assetQuery);
}
