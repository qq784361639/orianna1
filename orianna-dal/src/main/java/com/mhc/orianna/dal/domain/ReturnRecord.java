package com.mhc.orianna.dal.domain;

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
@TableName("orianna_return_record")
public class ReturnRecord extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 归还记录id
     */
    @TableId("return_record_id")
    private Integer returnRecordId;
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
     * 归还时间
     */
    @TableField("return_date")
    private Date returnDate;
    /**
     * 归还备注
     */
    @TableField("return_remark")
    private String returnRemark;
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


    public Integer getReturnRecordId() {
        return returnRecordId;
    }

    public void setReturnRecordId(Integer returnRecordId) {
        this.returnRecordId = returnRecordId;
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

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnRemark() {
        return returnRemark;
    }

    public void setReturnRemark(String returnRemark) {
        this.returnRemark = returnRemark;
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
        return "ReturnRecord{" +
        "returnRecordId=" + returnRecordId +
        ", assetId=" + assetId +
        ", assetNo=" + assetNo +
        ", returnDate=" + returnDate +
        ", returnRemark=" + returnRemark +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}";
    }
}
