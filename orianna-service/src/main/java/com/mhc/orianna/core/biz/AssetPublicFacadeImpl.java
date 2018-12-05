package com.mhc.orianna.core.biz;

import com.mhc.acura.dubbo.IDepartmentService;
import com.mhc.acura.dubbo.IUserService;
import com.mhc.acura.dubbo.model.Staff;
import com.mhc.acura.dubbo.model.User;
import com.mhc.bs.common.base.APIResult;
import com.mhc.orianna.api.AssetPublicFacade;
import com.mhc.orianna.api.dto.DepartmentDTO;
import com.mhc.orianna.api.dto.FindDepartmentAndPositionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: liuyi
 * @Date: 2018/12/5 3:00 PM
 * @Version 1.0
 */
@Service
@Slf4j
public class AssetPublicFacadeImpl implements AssetPublicFacade {
    @Resource
    private IUserService iUserService;
    @Resource
    private IDepartmentService iDepartmentService;

    @Override
    public APIResult<FindDepartmentAndPositionDTO> getDepartmentNameAndPositionByName(String name) {
        FindDepartmentAndPositionDTO dp = new FindDepartmentAndPositionDTO();
        try {
            User user = iUserService.findUserByRealNameOrNickName(name).getData().get(0);
            user = iUserService.findBy(Arrays.asList(user.getUserId())).getData().get(0);
            dp = new FindDepartmentAndPositionDTO();
            dp.setUserId(user.getUserId());
            dp.setName(name);
            Staff staff = iUserService.findStaff(user.getDingdingUserId(), user.getMobile(), user.getEmail()).getData();
            dp.setPosition(staff.getPosition());
            String departmentName = iDepartmentService
                    .findDepartmentTreeV2().getData()
                    .getNode(staff.getDepartmentIds().get(0))
                    .getValue().getName();
            dp.setDepartmentName(departmentName);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return APIResult.ok(dp);
    }

    @Override
    public APIResult<List<DepartmentDTO>> getAllDepartmentName() {
        List<DepartmentDTO> departmentDTOList = new ArrayList<>();
        List<Map<String, Object>> mapList = iDepartmentService.findTopDepartments().getData();
        mapList.forEach(map -> {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setDeptId(map.get("id").toString());
            departmentDTO.setDeptName(map.get("name").toString());
            departmentDTOList.add(departmentDTO);
        });
        return APIResult.ok(departmentDTOList);
    }
}

