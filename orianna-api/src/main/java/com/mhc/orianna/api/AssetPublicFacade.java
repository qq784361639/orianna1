
package com.mhc.orianna.api;

import com.mhc.bs.common.base.APIResult;
import com.mhc.orianna.api.dto.DepartmentDTO;
import com.mhc.orianna.api.dto.FindDepartmentAndPositionDTO;

import java.util.List;

/**
 * @Author: liuyi
 * @Date: 2018/12/5 2:58 PM
 * @Version 1.0
 */
public interface AssetPublicFacade {

    APIResult<FindDepartmentAndPositionDTO> getDepartmentNameAndPositionByName(String name);

    APIResult<List<DepartmentDTO>> getAllDepartmentName();
}

