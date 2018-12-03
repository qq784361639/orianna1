package com.mhc.orianna.api.enums;

import lombok.Getter;

/**
 * @Author: liuyi
 * @Date: 2018/12/2 10:24 AM
 * @Version 1.0
 */
public enum IsDeletedEnum {
    delete(1, "已删除"),
    not_delete(0, "未删除");

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
