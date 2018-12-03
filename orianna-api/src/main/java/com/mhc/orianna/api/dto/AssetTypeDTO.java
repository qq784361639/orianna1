package com.mhc.orianna.api.dto;


import com.mhc.orianna.api.enums.AssetTypeStatusEnum;
import com.mhc.orianna.api.enums.IsDeletedEnum;
import lombok.Data;

import java.io.Serializable;


@Data
public class AssetTypeDTO implements Serializable  {

    private Integer assetTypeId;
    /**
     * 资产类型名称
     */

    private String assetTypeName;
    /**
     * 资产类型编码
     */

    private String assetTypeCode;
    /**
     * 资产类型状态，默认值为1，1：启用 0:停用
     */

    private AssetTypeStatusEnum assetTypeStatusEnum;
    /**
     * 资产类型描述
     */

    private String assetTypeDescription;
    /**
     * 是否删除，默认值为0，0:未删除，1:已删除
     */

    private IsDeletedEnum isDeletedEnum;


}
