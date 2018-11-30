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
@TableName("orianna_store_record")
public class StoreRecord extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 入库记录id
     */
    @TableId(value = "store_record_id", type = IdType.AUTO)
    private Integer storeRecordId;
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
     * 入库时间
     */
    @TableField("store_date")
    private Date storeDate;
    /**
     * 入库备注
     */
    @TableField("store_remark")
    private String storeRemark;
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


    public Integer getStoreRecordId() {
        return storeRecordId;
    }

    public void setStoreRecordId(Integer storeRecordId) {
        this.storeRecordId = storeRecordId;
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

    public Date getStoreDate() {
        return storeDate;
    }

    public void setStoreDate(Date storeDate) {
        this.storeDate = storeDate;
    }

    public String getStoreRemark() {
        return storeRemark;
    }

    public void setStoreRemark(String storeRemark) {
        this.storeRemark = storeRemark;
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
        return "StoreRecord{" +
        "storeRecordId=" + storeRecordId +
        ", assetId=" + assetId +
        ", assetNo=" + assetNo +
        ", storeDate=" + storeDate +
        ", storeRemark=" + storeRemark +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}";
    }
}
