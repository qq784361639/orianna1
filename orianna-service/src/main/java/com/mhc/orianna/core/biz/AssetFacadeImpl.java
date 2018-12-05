package com.mhc.orianna.core.biz;

import com.mhc.acura.dubbo.IDepartmentService;
import com.mhc.acura.dubbo.IUserService;
import com.mhc.acura.dubbo.model.Staff;
import com.mhc.acura.dubbo.model.User;
import com.mhc.bs.common.base.APIResult;
import com.mhc.bs.common.base.page.PageInfo;
import com.mhc.orianna.api.AssetFacade;
import com.mhc.orianna.api.dto.AssetDTO;
import com.mhc.orianna.api.dto.DepartmentDTO;
import com.mhc.orianna.api.dto.FindDepartmentAndPositionDTO;
import com.mhc.orianna.api.dto.ReturnRecordDTO;
import com.mhc.orianna.api.query.AssetQuery;
import com.mhc.orianna.core.biz.service.AssetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class AssetFacadeImpl implements AssetFacade {
    @Resource
    private IUserService iUserService;
    @Resource
    private IDepartmentService iDepartmentService;
    @Autowired
    AssetService assetService;
    @Override
    public APIResult<Boolean> assetStorage(AssetDTO assetDTO) {
        Boolean flag = assetService.insertAsset(assetDTO);
        return APIResult.ok(flag);
    }

    @Override
    public APIResult<Boolean> borrowAsset(AssetDTO assetDTO) {
        Boolean flag = assetService.borrowAsset(assetDTO);
        return APIResult.ok(flag);
    }

    @Override
    public APIResult<Boolean> returnAsset(ReturnRecordDTO returnRecordDTO) {
        Boolean flag = assetService.returnAsset(returnRecordDTO);
        return APIResult.ok(flag);
    }

    @Override
    public APIResult<Boolean> withdrawal(AssetDTO assetDTO) {
        Boolean flag = assetService.withdrawal(assetDTO);
        return APIResult.ok(flag);
    }

    @Override
    public APIResult<AssetDTO> selectOneById(Integer assetId) {
        AssetDTO assetDTO = assetService.selectOneById(assetId);
        return APIResult.ok(assetDTO);
    }

    @Override
    public APIResult<Boolean> updateAsset(AssetDTO assetDTO) {
        Boolean flag = assetService.updateAsset(assetDTO);
        return APIResult.ok(flag);
    }

    @Override
    public APIResult<PageInfo<AssetDTO>> queryAsset(AssetQuery assetQuery) {
        PageInfo<AssetDTO> page = assetService.selectPage(assetQuery);
        return APIResult.ok(page);
    }

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
            dp.setJob(staff.getPosition());
            String departmentName = iDepartmentService
                    .findDepartmentTreeV2().getData()
                    .getNode(staff.getDepartmentIds().get(0))
                    .getValue().getName();
            dp.setDeptName(departmentName);
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
