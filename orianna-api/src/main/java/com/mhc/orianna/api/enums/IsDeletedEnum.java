package com.mhc.orianna.api.enums;

import lombok.Getter;

/**
 * 是否删除
 */
public enum IsDeletedEnum {
    DELETE(1, "已删除"),
    NOT_DELETE(0, "未删除");

    @Getter
    private Integer code;
    @Getter
    private String desc;

    IsDeletedEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static IsDeletedEnum getEnumByCode(Integer code) {
        for (IsDeletedEnum isDeletedEnum : IsDeletedEnum.values()){
            if (isDeletedEnum.getCode().equals(code)) {
                return isDeletedEnum;
            }

        }
        return null;
    }


}
