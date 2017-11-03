/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.MyBackupServiceTest
   Module Description   :

   Date Created      : 2017年10月26日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.senao.factory.HandlerFactory;
import com.senao.service.MyBackupService;

/**
 * @author 015336
 */
public class MyBackupServiceTest {
	private HandlerFactory handlerFactory;

	@Test
	public void 正常執行() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		MyBackupService myBackupService = (MyBackupService) ctx.getBean("myBackupService");
		try {
			myBackupService.ProcessJsonConfigs();
			myBackupService.DoBackup();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
