package com.mhc.orianna.dal.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mhc.framework.common.base.dal.BaseModel;

/**
 * <p>
 * 
 * </p>
 *
 * @author 麦禾(maihe@maihaoche.com)
 * @since 2018-11-30
 */
@TableName("orianna_asset")
public class Asset extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 资产id
     */
    @TableId("asset_id")
    private Integer assetId;
    /**
     * 资产编号
     */
    @TableField("asset_no")
    private String assetNo;
    /**
     * 目录编号
     */
    @TableField("catalog_id")
    private Integer catalogId;
    /**
     * 资产类型名称
     */
    @TableField("asset_type_name")
    private String assetTypeName;
    /**
     * 品牌
     */
    @TableField("catalog_brand")
    private String catalogBrand;
    /**
     * 型号
     */
    @TableField("catalog_model")
    private String catalogModel;
    /**
     * 资产备注
     */
    @TableField("asset_remark")
    private String assetRemark;
    /**
     * 资产来源，默认值0，0:公司资产，1:租赁资产
     */
    @TableField("asset_source")
    private Integer assetSource;
    /**
     * 资产序列号
     */
    @TableField("asset_serial_no")
    private String assetSerialNo;
    /**
     * 资产供应商
     */
    @TableField("asset_supplier")
    private String assetSupplier;
    /**
     * 资产采购或者租赁时间
     */
    @TableField("asset_purchase_or_rent_date")
    private Date assetPurchaseOrRentDate;
    /**
     * 资产租赁到期时间
     */
    @TableField("asset_rent_end_date")
    private Date assetRentEndDate;
    /**
     * 资产启用时期
     */
    @TableField("asset_start_date")
    private Date assetStartDate;
    /**
     * 资产状态，默认值为0，0:未发放，1:已发放，2:已退租
     */
    @TableField("asset_status")
    private Integer assetStatus;
    /**
     * 资产流转类型，默认值为0，0:资产借用，1:资产发放
     */
    @TableField("asset_flow_type")
    private Integer assetFlowType;
    /**
     * 资产领用时间
     */
    @TableField("asset_borrow_date")
    private Date assetBorrowDate;
    /**
     * 资产预计归还时间
     */
    @TableField("asset_predict_return_date")
    private Date assetPredictReturnDate;
    /**
     * 资产原值或者租金
     */
    @TableField("asset_original_value")
    private BigDecimal assetOriginalValue;
    /**
     * 领用审批编号
     */
    @TableField("borrow_approval_no")
    private String borrowApprovalNo;
    /**
     * 领用人id
     */
    @TableField("auth_staff_id")
    private Integer authStaffId;
    /**
     * 领用人姓名
     */
    @TableField("auth_staff_name")
    private String authStaffName;
    /**
     * 领用人部门
     */
    @TableField("auth_staff_dept")
    private String authStaffDept;
    /**
     * 领用人岗位
     */
    @TableField("auth_staff_job")
    private String authStaffJob;
    /**
     * 资产退租时间
     */
    @TableField("asset_back_rent_date")
    private Date assetBackRentDate;
    /**
     * 资产退租记录
     */
    @TableField("asset_back_rent_record")
    private String assetBackRentRecord;
    /**
     * 是否删除，默认值为0，0:未删除，1:已删除
     */
    @TableField("is_deleted")
    private Integer isDeleted;
    /**
     * 创建时间
     */
    @TableField("gmt_create")
    private Date gmtCreate;
    /**
     * 修改时间
     */
    @TableField("gmt_modified")
    private Date gmtModified;


    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getAssetTypeName() {
        return assetTypeName;
    }

    public void setAssetTypeName(String assetTypeName) {
        this.assetTypeName = assetTypeName;
    }

    public String getCatalogBrand() {
        return catalogBrand;
    }

    public void setCatalogBrand(String catalogBrand) {
        this.catalogBrand = catalogBrand;
    }

    public String getCatalogModel() {
        return catalogModel;
    }

    public void setCatalogModel(String catalogModel) {
        this.catalogModel = catalogModel;
    }

    public String getAssetRemark() {
        return assetRemark;
    }

    public void setAssetRemark(String assetRemark) {
        this.assetRemark = assetRemark;
    }

    public Integer getAssetSource() {
        return assetSource;
    }

    public void setAssetSource(Integer assetSource) {
        this.assetSource = assetSource;
    }

    public String getAssetSerialNo() {
        return assetSerialNo;
    }

    public void setAssetSerialNo(String assetSerialNo) {
        this.assetSerialNo = assetSerialNo;
    }

    public String getAssetSupplier() {
        return assetSupplier;
    }

    public void setAssetSupplier(String assetSupplier) {
        this.assetSupplier = assetSupplier;
    }

    public Date getAssetPurchaseOrRentDate() {
        return assetPurchaseOrRentDate;
    }

    public void setAssetPurchaseOrRentDate(Date assetPurchaseOrRentDate) {
        this.assetPurchaseOrRentDate = assetPurchaseOrRentDate;
    }

    public Date getAssetRentEndDate() {
        return assetRentEndDate;
    }

    public void setAssetRentEndDate(Date assetRentEndDate) {
        this.assetRentEndDate = assetRentEndDate;
    }

    public Date getAssetStartDate() {
        return assetStartDate;
    }

    public void setAssetStartDate(Date assetStartDate) {
        this.assetStartDate = assetStartDate;
    }

    public Integer getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(Integer assetStatus) {
        this.assetStatus = assetStatus;
    }

    public Integer getAssetFlowType() {
        return assetFlowType;
    }

    public void setAssetFlowType(Integer assetFlowType) {
        this.assetFlowType = assetFlowType;
    }

    public Date getAssetBorrowDate() {
        return assetBorrowDate;
    }

    public void setAssetBorrowDate(Date assetBorrowDate) {
        this.assetBorrowDate = assetBorrowDate;
    }

    public Date getAssetPredictReturnDate() {
        return assetPredictReturnDate;
    }

    public void setAssetPredictReturnDate(Date assetPredictReturnDate) {
        this.assetPredictReturnDate = assetPredictReturnDate;
    }

    public BigDecimal getAssetOriginalValue() {
        return assetOriginalValue;
    }

    public void setAssetOriginalValue(BigDecimal assetOriginalValue) {
        this.assetOriginalValue = assetOriginalValue;
    }

    public String getBorrowApprovalNo() {
        return borrowApprovalNo;
    }

    public void setBorrowApprovalNo(String borrowApprovalNo) {
        this.borrowApprovalNo = borrowApprovalNo;
    }

    public Integer getAuthStaffId() {
        return authStaffId;
    }

    public void setAuthStaffId(Integer authStaffId) {
        this.authStaffId = authStaffId;
    }

    public String getAuthStaffName() {
        return authStaffName;
    }

    public void setAuthStaffName(String authStaffName) {
        this.authStaffName = authStaffName;
    }

    public String getAuthStaffDept() {
        return authStaffDept;
    }

    public void setAuthStaffDept(String authStaffDept) {
        this.authStaffDept = authStaffDept;
    }

    public String getAuthStaffJob() {
        return authStaffJob;
    }

    public void setAuthStaffJob(String authStaffJob) {
        this.authStaffJob = authStaffJob;
    }

    public Date getAssetBackRentDate() {
        return assetBackRentDate;
    }

    public void setAssetBackRentDate(Date assetBackRentDate) {
        this.assetBackRentDate = assetBackRentDate;
    }

    public String getAssetBackRentRecord() {
        return assetBackRentRecord;
    }

    public void setAssetBackRentRecord(String assetBackRentRecord) {
        this.assetBackRentRecord = assetBackRentRecord;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Asset{" +
        "assetId=" + assetId +
        ", assetNo=" + assetNo +
        ", catalogId=" + catalogId +
        ", assetTypeName=" + assetTypeName +
        ", catalogBrand=" + catalogBrand +
        ", catalogModel=" + catalogModel +
        ", assetRemark=" + assetRemark +
        ", assetSource=" + assetSource +
        ", assetSerialNo=" + assetSerialNo +
        ", assetSupplier=" + assetSupplier +
        ", assetPurchaseOrRentDate=" + assetPurchaseOrRentDate +
        ", assetRentEndDate=" + assetRentEndDate +
        ", assetStartDate=" + assetStartDate +
        ", assetStatus=" + assetStatus +
        ", assetFlowType=" + assetFlowType +
        ", assetBorrowDate=" + assetBorrowDate +
        ", assetPredictReturnDate=" + assetPredictReturnDate +
        ", assetOriginalValue=" + assetOriginalValue +
        ", borrowApprovalNo=" + borrowApprovalNo +
        ", authStaffId=" + authStaffId +
        ", authStaffName=" + authStaffName +
        ", authStaffDept=" + authStaffDept +
        ", authStaffJob=" + authStaffJob +
        ", assetBackRentDate=" + assetBackRentDate +
        ", assetBackRentRecord=" + assetBackRentRecord +
        ", isDeleted=" + isDeleted +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}";
    }



}
