package com.mhc.orianna.api.dto;

import com.mhc.orianna.api.enums.IsDeletedEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: liuyi
 * @Date: 2018/12/2 10:12 AM
 * @Version 1.0
 */
@Data
public class AssetCatalogDTO implements Serializable {

    /**
     * 自增
     */
    private Integer assetCatalogId;
    /**
     * 资产目录编号
     */
    private String assetCatalogNum;
    /**
     * 目录类型名称
     */
    private  String assetTypeName;
    /**
     * 目录品牌
     */
    private String assetCatalogBrand;
    /**
     * 目录型号
     */
    private String assetCatalogModel;
    /**
     * 目录备注
     */
    private String assetCatalogRemark;
    /**
     * 删除状态，默认值为0，0:未删除，1:已删除
     */
    private IsDeletedEnum isDeletedEnum;
}
