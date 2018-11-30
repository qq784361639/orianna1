package com.mhc.orianna.dal.manager.impl;

import com.mhc.orianna.dal.domain.Asset;
import com.mhc.orianna.dal.dao.AssetDao;
import com.mhc.orianna.dal.manager.AssetManager;
import com.mhc.framework.common.base.dal.BaseManagerImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 麦禾(maihe@maihaoche.com)
 * @since 2018-11-30
 */
@Service
public class AssetManagerImpl extends BaseManagerImpl<AssetDao, Asset> implements AssetManager {

}
