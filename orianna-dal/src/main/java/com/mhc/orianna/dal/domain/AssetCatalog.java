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
@TableName("orianna_asset_catalog")
public class AssetCatalog extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 资产目录id
     */
    @TableId(value = "catalog_id", type = IdType.AUTO)
    private Integer catalogId;
    /**
     * 资产目录编号
     */
    @TableField("catalog_num")
    private String catalogNum;
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
     * 目录备注
     */
    @TableField("catalog_remark")
    private String catalogRemark;
    /**
     * 是否删除，默认资0，0:未删除，1:已删除
     */
    @TableField("is_deleted")
    private Integer isDeleted;
    /**
     * 记录生成时间
     */
    @TableField("gmt_create")
    private Date gmtCreate;
    /**
     * 记录修改时间
     */
    @TableField("gmt_modified")
    private Date gmtModified;


    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogNum() {
        return catalogNum;
    }

    public void setCatalogNum(String catalogNum) {
        this.catalogNum = catalogNum;
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

    public String getCatalogRemark() {
        return catalogRemark;
    }

    public void setCatalogRemark(String catalogRemark) {
        this.catalogRemark = catalogRemark;
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
        return "AssetCatalog{" +
        "catalogId=" + catalogId +
        ", catalogNum=" + catalogNum +
        ", assetTypeName=" + assetTypeName +
        ", catalogBrand=" + catalogBrand +
        ", catalogModel=" + catalogModel +
        ", catalogRemark=" + catalogRemark +
        ", isDeleted=" + isDeleted +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}";
    }
}
