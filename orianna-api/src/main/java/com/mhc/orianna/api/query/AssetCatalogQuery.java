package com.mhc.orianna.api.query;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: liuyi
 * @Date: 2018/12/3 2:17 PM
 * @Version 1.0
 */
@Data
public class AssetCatalogQuery extends BaseDubboRequest implements Serializable {
    private String assetTypeName;
    private String catalogBrand;
    private String catalogModel;
    private String catalogNum;
}
