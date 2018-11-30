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
@TableName("orianna_asset_type")
public class AssetType extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 资产类型id
     */
    @TableId(value = "asset_type_id", type = IdType.AUTO)
    private Integer assetTypeId;
    /**
     * 资产类型名称
     */
    @TableField("asset_type_name")
    private String assetTypeName;
    /**
     * 资产类型编码
     */
    @TableField("asset_type_code")
    private String assetTypeCode;
    /**
     * 资产类型状态，默认值为1，1：启用 0:停用
     */
    @TableField("asset_status")
    private Integer assetStatus;
    /**
     * 资产类型描述
     */
    @TableField("asset_description")
    private String assetDescription;
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


    public Integer getAssetTypeId() {
        return assetTypeId;
    }

    public void setAssetTypeId(Integer assetTypeId) {
        this.assetTypeId = assetTypeId;
    }

    public String getAssetTypeName() {
        return assetTypeName;
    }

    public void setAssetTypeName(String assetTypeName) {
        this.assetTypeName = assetTypeName;
    }

    public String getAssetTypeCode() {
        return assetTypeCode;
    }

    public void setAssetTypeCode(String assetTypeCode) {
        this.assetTypeCode = assetTypeCode;
    }

    public Integer getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(Integer assetStatus) {
        this.assetStatus = assetStatus;
    }

    public String getAssetDescription() {
        return assetDescription;
    }

    public void setAssetDescription(String assetDescription) {
        this.assetDescription = assetDescription;
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

    @Override
    public String toString() {
        return "AssetType{" +
        "assetTypeId=" + assetTypeId +
        ", assetTypeName=" + assetTypeName +
        ", assetTypeCode=" + assetTypeCode +
        ", assetStatus=" + assetStatus +
        ", assetDescription=" + assetDescription +
        ", isDeleted=" + isDeleted +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}";
    }
}
