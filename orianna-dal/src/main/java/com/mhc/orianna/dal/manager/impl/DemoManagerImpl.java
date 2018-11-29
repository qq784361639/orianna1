/**  
 * All rights Reserved, Designed By www.maihaoche.com
 * 
 * @Package com.mhc.orianna.dal.manager.impl
 * @author: 文远（wenyuan@maihaoche.com）
 * @date: 2018-11-29 20:53:45
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved. 
 * 注意：本内容仅限于卖好车内部传阅，禁止外泄以及用于其他的商业目
 */ 
package com.mhc.orianna.dal.manager.impl;

import com.mhc.orianna.dal.domain.Demo;
import com.mhc.orianna.dal.dao.DemoDao;
import com.mhc.orianna.dal.manager.DemoManager;
import com.mhc.framework.common.base.dal.BaseManagerImpl;
import org.springframework.stereotype.Component;

/**   
 * <p> 测试 Manager实现类 </p>
 *   
 * @author: 文远（wenyuan@maihaoche.com）
 * @date: 2018-11-29 20:53:45 
 * @since V1.0 
 */
@Component
public class DemoManagerImpl extends BaseManagerImpl<DemoDao, Demo> implements DemoManager {

}
