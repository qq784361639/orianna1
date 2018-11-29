/**  
 * All rights Reserved, Designed By www.maihaoche.com
 * 
 * @Package com.mhc.orianna.dal.domain
 * @author: 文远（wenyuan@maihaoche.com）
 * @date: 2018-11-29 20:53:45
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved. 
 * 注意：本内容仅限于卖好车内部传阅，禁止外泄以及用于其他的商业目
 */ 
package com.mhc.orianna.dal.domain;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mhc.framework.common.base.dal.BaseModel;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**   
 * <p>  </p>
 *   
 * @author: 文远（wenyuan@maihaoche.com）
 * @date: 2018-11-29 20:53:45 
 * @since V1.0 
 */
@TableName("asset_four_asset")
public class AssetFourAsset extends BaseModel {

    private static final long serialVersionUID = 1L;

    @TableId("asset_id")
	private Integer assetId;
	@TableField("asset_no")
	private String assetNo;
	@TableField("catalog_id")
	private Integer catalogId;
	@TableField("asset_type_name")
	private String assetTypeName;
	@TableField("catalog_brand")
	private String catalogBrand;
	@TableField("catalog_model")
	private String catalogModel;
	@TableField("asset_remark")
	private String assetRemark;
	@TableField("asset_source")
	private String assetSource;
	@TableField("asset_serial_no")
	private Integer assetSerialNo;
	@TableField("asset_supplier")
	private String assetSupplier;
	@TableField("asset_purchase_or_rent_date")
	private Date assetPurchaseOrRentDate;


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

	public String getAssetSource() {
		return assetSource;
	}

	public void setAssetSource(String assetSource) {
		this.assetSource = assetSource;
	}

	public Integer getAssetSerialNo() {
		return assetSerialNo;
	}

	public void setAssetSerialNo(Integer assetSerialNo) {
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


	@Override
	public String toString() {
		return "AssetFourAsset{" +
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
			"}";
	}

	//@Override
	//public String toString() {
	//	return ReflectionToStringBuilder.toString(this);
	//}
}