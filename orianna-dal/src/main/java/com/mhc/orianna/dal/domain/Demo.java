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

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mhc.framework.common.base.dal.BaseModel;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**   
 * <p> 测试 </p>
 *   
 * @author: 文远（wenyuan@maihaoche.com）
 * @date: 2018-11-29 20:53:45 
 * @since V1.0 
 */
@TableName("orianna_demo")
public class Demo extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 序列ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 描述
     */
	private String desc;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}


	@Override
	public String toString() {
		return "Demo{" +
			"id=" + id +
			", desc=" + desc +
			"}";
	}

	//@Override
	//public String toString() {
	//	return ReflectionToStringBuilder.toString(this);
	//}
}