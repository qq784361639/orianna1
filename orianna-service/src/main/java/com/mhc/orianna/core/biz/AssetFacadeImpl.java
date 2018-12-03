package com.mhc.orianna.core.biz;

import com.mhc.bs.common.base.APIResult;
import com.mhc.bs.common.base.page.PageInfo;
import com.mhc.orianna.api.AssetFacade;
import com.mhc.orianna.api.dto.AssetDTO;
import com.mhc.orianna.api.dto.ReturnRecordDTO;
import com.mhc.orianna.api.query.AssetQuery;
import com.mhc.orianna.core.biz.service.AssetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AssetFacadeImpl implements AssetFacade {
    @Autowired
    AssetService assetService;
    @Override
    public APIResult<Boolean> assetStorage(AssetDTO assetDTO) {
        Boolean flag = assetService.insertAsset(assetDTO);
        return APIResult.ok(flag);
    }

    @Override
    public APIResult<Boolean> borrowAsset(AssetDTO assetDTO) {
        Boolean flag = assetService.borrowAsset(assetDTO);
        return APIResult.ok(flag);
    }

    @Override
    public APIResult<Boolean> returnAsset(ReturnRecordDTO returnRecordDTO) {
        Boolean flag = assetService.returnAsset(returnRecordDTO);
        return APIResult.ok(flag);
    }

    @Override
    public APIResult<Boolean> withdrawal(AssetDTO assetDTO) {
        Boolean flag = assetService.withdrawal(assetDTO);
        return APIResult.ok(flag);
    }

    @Override
    public APIResult<AssetDTO> selectOneById(Integer assetId) {
        AssetDTO assetDTO = assetService.selectOneById(assetId);
        return APIResult.ok(assetDTO);
    }

    @Override
    public APIResult<Boolean> updateAsset(AssetDTO assetDTO) {
        Boolean flag = assetService.updateAsset(assetDTO);
        return APIResult.ok(flag);
    }

    @Override
    public APIResult<PageInfo<AssetDTO>> queryAsset(AssetQuery assetQuery) {
        PageInfo<AssetDTO> page = assetService.selectPage(assetQuery);
        return APIResult.ok(page);
    }
}
