package com.mhc.orianna.dal.dao;

import com.mhc.orianna.dal.domain.Asset;
import com.mhc.framework.common.base.dal.BaseDao;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 麦禾(maihe@maihaoche.com)
 * @since 2018-11-30
 */
@Service("assetDao")
public interface AssetDao extends BaseDao<Asset> {
    //更新领用时间和预计归还时间都为空
    Integer updateNullDateOnBorrowDateAndReturnDate(String assetNo);

}
