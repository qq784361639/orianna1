/**  
 * All rights Reserved, Designed By www.maihaoche.com
 * 
 * @Package com.mhc.orianna.core
 * @author: 文远（wenyuan@maihaoche.com）
 * @date: 2018-11-29 20:53:45
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved. 
 * 注意：本内容仅限于卖好车内部传阅，禁止外泄以及用于其他的商业目
 */ 
package com.mhc.orianna.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mhc.framework.common.exception.annotation.EnableExceptionManagement;
import com.mhc.framework.support.log.anno.EnableLogManagement;
import com.spring4all.swagger.EnableSwagger2Doc;

/**   
 * <p> orianna 服务启动类 </p>
 *   
 * @author: 文远（wenyuan@maihaoche.com）
 * @date: 2018-11-29 20:53:45 
 * @since V1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.mhc.orianna.dal", "com.mhc.orianna.core","com.mhc.framework.common.exception.handler", "com.mhc.framework.support" })
@EnableTransactionManagement
@EnableLogManagement
@EnableExceptionManagement
@ImportResource("classpath:orianna-all.xml")
@EnableSwagger2Doc
@RestController
public class OriannaApplication {
	private final static Logger logger = LoggerFactory.getLogger(OriannaApplication.class);

	/**    
	 * <p> Start启动入口 </p>
	 *  
	 * @param args 
	 */
	public static void main(String[] args) {
		SpringApplication.run(OriannaApplication.class, args);
		logger.info("sample started. http://localhost:8085/hello/test");
	}
	
	/**    
	 * <p> 测试 </p>
	 *  
	 * @param name
	 * @return 
	 */
	//跳转 path = /hello/  {name} 代表一个变量
	@RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
	public Object hello(@PathVariable String name) {
		return "Hello world " + name;
	}
}