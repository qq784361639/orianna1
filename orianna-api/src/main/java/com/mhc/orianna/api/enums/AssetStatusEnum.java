package com.mhc.orianna.api.enums;

import lombok.Getter;
/**
 * 资产状态，默认值为0，0:未发放，1:已发放，2:已退租
 */
public enum AssetStatusEnum {
    NOT_ISSUE(0, "未发放"),
    ISSUE(1, "已发放"),
    WITHDRAWAL(2, "已退租");

    @Getter
    private Integer code;
    @Getter
    private String desc;

    AssetStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static AssetStatusEnum getEnumByCode(Integer code) {
        for (AssetStatusEnum assetStatusEnum : AssetStatusEnum.values()){
            if (assetStatusEnum.getCode().equals(code)) {
                return assetStatusEnum;
            }

        }
        return null;
    }
}
