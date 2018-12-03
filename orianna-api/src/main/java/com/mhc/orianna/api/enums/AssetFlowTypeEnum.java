package com.mhc.orianna.api.enums;

import lombok.Getter;

/**
 * 资产流转类型，默认值为0，0:资产借用，1:资产发放
 */
public enum AssetFlowTypeEnum {
    ASSET_BORROW(0, "资产借用"),
    ASSET_ISSUE(1, "资产发放");

    @Getter
    private Integer code;
    @Getter
    private String desc;

    AssetFlowTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static AssetFlowTypeEnum getEnumByCode(Integer code) {
        for (AssetFlowTypeEnum assetFlowTypeEnum : AssetFlowTypeEnum.values()){
            if (assetFlowTypeEnum.getCode().equals(code)) {
                return assetFlowTypeEnum;
            }

        }
        return null;
    }

}
