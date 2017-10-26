/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.MyBackupServiceTest
   Module Description   :

   Date Created      : 2017年10月26日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao;

import org.junit.Test;

import com.senao.service.MyBackupService;

/**
 * @author 015336
 */
public class MyBackupServiceTest {

	@Test
	public void 正常執行() {
		MyBackupService myBackupService = new MyBackupService();
		myBackupService.ProcessJsonConfigs();
	}
}
