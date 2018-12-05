package com.mhc.orianna.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: liuyi
 * @Date: 2018/12/5 3:05 PM
 * @Version 1.0
 */
@Data
public class DepartmentDTO implements Serializable {
    private static final long serialVersionUID = -7698053381296645631L;
    private String deptId;
    private String deptName;

}

