package com.mhc.orianna.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: liuyi
 * @Date: 2018/12/5 3:07 PM
 * @Version 1.0
 */
@Data
public class FindDepartmentAndPositionDTO implements Serializable {
    private static final long serialVersionUID = -2606050679782679582L;
    private String userId;
    private String name;
    private String position;
    private String departmentName;

}

