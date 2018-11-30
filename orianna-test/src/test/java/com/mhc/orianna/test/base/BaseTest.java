/**  
 * All rights Reserved, Designed By www.maihaoche.com
 * 
 * @Package com.mhc.orianna.test.base
 * @author: 文远（wenyuan@maihaoche.com）
 * @date: 2018-11-29 20:53:45
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved. 
 * 注意：本内容仅限于卖好车内部传阅，禁止外泄以及用于其他的商业目
 */ 
package com.mhc.orianna.test.base;

import com.mhc.orianna.core.OriannaApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**  
 * <p> orianna模块测试基类 </p>
 *   
 * @author: 文远（wenyuan@maihaoche.com）
 * @date: 2018-11-29 20:53:45
 * @since V1.0 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OriannaApplication.class)
@ActiveProfiles(profiles = "local")
public abstract class BaseTest {

}
