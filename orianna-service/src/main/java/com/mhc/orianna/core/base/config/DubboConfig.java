/**  
 * All rights Reserved, Designed By www.maihaoche.com
 * 
 * @Package com.mhc.orianna.core.base.config
 * @author: 文远（wenyuan@maihaoche.com）
 * @date: 2018-11-29 20:53:45
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved. 
 * 注意：本内容仅限于卖好车内部传阅，禁止外泄以及用于其他的商业目
 */ 

package com.mhc.orianna.core.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**   
 * <p> dubbo配置 </p>
 *   
 * @author: 文远（wenyuan@maihaoche.com）
 * @date: 2018-11-29 20:53:45
 * @since V1.0 
 */
@Configuration
@ImportResource("classpath:dubbo/dubbo-all.xml")
public class DubboConfig {

}
