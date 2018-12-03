package com.mhc.orianna.api.enums;

import lombok.Getter;

public enum AssetTypeStatusEnum {
    ENABLE(1, "启用"),
    DISABLE(0, "停用");

    @Getter
    private Integer code;
    @Getter
    private String desc;

    AssetTypeStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static AssetTypeStatusEnum getEnumByCode(Integer code) {
        for (AssetTypeStatusEnum assetTypeStatusEnum : AssetTypeStatusEnum.values()){
            if (assetTypeStatusEnum.getCode().equals(code)) {
                return assetTypeStatusEnum;
            }

        }
        return null;
    }


}
