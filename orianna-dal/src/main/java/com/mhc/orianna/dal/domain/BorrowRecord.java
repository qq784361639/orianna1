package com.mhc.orianna.dal.domain;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("orianna_borrow_record")
public class BorrowRecord extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 领用记录id
     */
    @TableId(value = "borrow_record_id", type = IdType.AUTO)
    private Integer borrowRecordId;
    /**
     * 领用审批编号
     */
    @TableField("borrow_approval_no")
    private String borrowApprovalNo;
    /**
     * 领用人id
     */
    @TableField("auth_staff_id")
    private String authStaffId;
    /**
     * 领用人花名
     */
    @TableField("auth_staff_name")
    private String authStaffName;
    /**
     * 资产id
     */
    @TableField("asset_id")
    private Integer assetId;
    /**
     * 资产编号
     */
    @TableField("asset_no")
    private String assetNo;
    /**
     * 领用时间
     */
    @TableField("borrow_date")
    private Date borrowDate;
    /**
     * 流转类型，默认值0，0:资产借用，1:资产发放
     */
    @TableField("asset_flow_type")
    private Integer assetFlowType;
    /**
     * 领用备注
     */
    @TableField("borrow_remark")
    private String borrowRemark;
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


    public Integer getBorrowRecordId() {
        return borrowRecordId;
    }

    public void setBorrowRecordId(Integer borrowRecordId) {
        this.borrowRecordId = borrowRecordId;
    }

    public String getBorrowApprovalNo() {
        return borrowApprovalNo;
    }

    public void setBorrowApprovalNo(String borrowApprovalNo) {
        this.borrowApprovalNo = borrowApprovalNo;
    }

    public String getAuthStaffId() {
        return authStaffId;
    }

    public void setAuthStaffId(String authStaffId) {
        this.authStaffId = authStaffId;
    }

    public String getAuthStaffName() {
        return authStaffName;
    }

    public void setAuthStaffName(String authStaffName) {
        this.authStaffName = authStaffName;
    }

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

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Integer getAssetFlowType() {
        return assetFlowType;
    }

    public void setAssetFlowType(Integer assetFlowType) {
        this.assetFlowType = assetFlowType;
    }

    public String getBorrowRemark() {
        return borrowRemark;
    }

    public void setBorrowRemark(String borrowRemark) {
        this.borrowRemark = borrowRemark;
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

    @Override
    public String toString() {
        return "BorrowRecord{" +
        "borrowRecordId=" + borrowRecordId +
        ", borrowApprovalNo=" + borrowApprovalNo +
        ", authStaffId=" + authStaffId +
        ", authStaffName=" + authStaffName +
        ", assetId=" + assetId +
        ", assetNo=" + assetNo +
        ", borrowDate=" + borrowDate +
        ", assetFlowType=" + assetFlowType +
        ", borrowRemark=" + borrowRemark +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}";
    }
}
