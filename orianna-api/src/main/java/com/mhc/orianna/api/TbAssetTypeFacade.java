/**  
 * All rights Reserved, Designed By www.maihaoche.com
 * 
 * @Package com.mhc.orianna.api
 * @author: 文远（wenyuan@maihaoche.com）
 * @date: 2018-11-29 20:53:45
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved. 
 * 注意：本内容仅限于卖好车内部传阅，禁止外泄以及用于其他的商业目
 */ 
package com.mhc.orianna.api;

import com.mhc.bs.common.base.APIResult;

/**   
 * <p>  服务接口 </p>
 *   
 * @author: 文远（wenyuan@maihaoche.com）
 * @date: 2018-11-29 20:53:45
 * @since V1.0 
 */
public interface TbAssetTypeFacade {
	/**
	 * <p> 测试Hello World </p>
	 *  
	 * @param world 输入字符串
	 * @return APIResult<String>
	 */
	APIResult<String> hello(String world);
}
