package com.mhc.orianna.api.query;

import com.mhc.bs.common.base.page.PageInfo;
import com.mhc.orianna.api.dto.AssetDTO;
import lombok.Data;

import java.io.Serializable;
@Data
public class AssetQuery extends BaseDubboRequest implements Serializable {
    /**
     * 资产编号
     */
    private String assetNo;
    /**
     * 资产类型名称
     */
    private String assetTypeName;
    /**
     *资产状态
     */
    private Integer assetStatus;
    /**
     *资产来源
     */
    private Integer assetSource;
    /**
     *领用人花名
     */
    private String authStaffName;
    /**
     *领用人部门
     */
    private String authStaffDept;
    /**
     *供应商
     */
    private String assetSupplier;
    /**
     *流转类型
     */
    private Integer assetFlowType;


}
