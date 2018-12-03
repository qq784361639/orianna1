package com.mhc.orianna.api.enums;

import lombok.Getter;
/**
 * 资产来源，默认值0，0:公司资产，1:租赁资产
 */
public enum AssetSourceEnum {
    COMPANY_ASSET(0, "公司资产"),
    RENT_ASSET(1, "租赁资产");

    @Getter
    private Integer code;
    @Getter
    private String desc;

    AssetSourceEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static AssetSourceEnum getEnumByCode(Integer code) {
        for (AssetSourceEnum assetSourceEnum : AssetSourceEnum.values()){
            if (assetSourceEnum.getCode().equals(code)) {
                return assetSourceEnum;
            }

        }
        return null;
    }


}
