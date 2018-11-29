/**  
 * All rights Reserved, Designed By www.maihaoche.com
 * 
 * @Package com.mhc.orianna.core.biz
 * @author: 文远（wenyuan@maihaoche.com）
 * @date: 2018-11-29 20:53:45
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved. 
 * 注意：本内容仅限于卖好车内部传阅，禁止外泄以及用于其他的商业目
 */ 
package com.mhc.orianna.core.biz;

import com.mhc.orianna.api.DemoFacade;
import com.mhc.bs.common.base.APIResult;
import org.springframework.stereotype.Service;

/**   
 * <p> 测试 服务实现类 </p>
 *   
 * @author: 文远（wenyuan@maihaoche.com）
 * @date: 2018-11-29 20:53:45
 * @since V1.0 
 */
@Service
public class DemoFacadeImpl implements DemoFacade {

	@Override
	public APIResult<String> hello(String world) {
		return APIResult.ok("Hello "+ world);
	}
}
