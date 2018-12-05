package com.mhc.orianna.api.dto;

import com.mhc.orianna.api.enums.AssetFlowTypeEnum;
import com.mhc.orianna.api.enums.AssetSourceEnum;
import com.mhc.orianna.api.enums.AssetStatusEnum;
import com.mhc.orianna.api.enums.IsDeletedEnum;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class AssetDTO implements Serializable{
    private static final long serialVersionUID = -9169746097433636637L;
    /**
     * 资产id
     */
    private Integer assetId;
    /**
     * 资产编号
     */
    private String assetNo;
    /**
     * 目录编号
     */
    private Integer catalogId;
    /**
     * 资产类型名称
     */
    private String assetTypeName;
    /**
     * 资产类型编号
     */
    private String assetTypeNo;
    /**
     * 品牌
     */
    private String catalogBrand;
    /**
     * 型号
     */
    private String catalogModel;
    /**
     * 资产备注
     */
    private String assetRemark;
    /**
     * 资产来源，默认值0，0:公司资产，1:租赁资产
     */
    private AssetSourceEnum assetSourceEnum;
    /**
     * 资产序列号
     */
    private String assetSerialNo;
    /**
     * 资产供应商
     */
    private String assetSupplier;
    /**
     * 资产采购或者租赁时间
     */
    private Date assetPurchaseOrRentDate;
    /**
     * 资产租赁到期时间
     */
    private Date assetRentEndDate;
    /**
     * 资产启用时期
     */
    private Date assetStartDate;
    /**
     * 资产状态，默认值为0，0:未发放，1:已发放，2:已退租
     */

    private AssetStatusEnum assetStatusEnum;
    /**
     * 资产流转类型，默认值为0，0:资产借用，1:资产发放
     */
    private AssetFlowTypeEnum assetFlowTypeEnum;
    /**
     * 资产领用时间
     */
    private Date assetBorrowDate;
    /**
     * 资产预计归还时间
     */
    private Date assetPredictReturnDate;
    /**
     * 资产原值或者租金
     */
    private BigDecimal assetOriginalValue;
    /**
     * 领用审批编号
     */
    private String borrowApprovalNo;
    /**
     * 领用人id
     */
    private Long authStaffId;
    /**
     * 领用人花名
     */
    private String authStaffName;
    /**
     * 领用人部门
     */
    private String authStaffDept;
    /**
     * 领用人岗位
     */
    private String authStaffJob;
    /**
     * 资产退租时间
     */
    private Date assetBackRentDate;
    /**
     * 资产退租记录
     */
    private String assetBackRentRecord;
    /**
     * 是否删除，默认值为0，0:未删除，1:已删除
     */
    private IsDeletedEnum isDeletedEnum;

}
