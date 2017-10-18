/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.ConfigManagerTest
   Module Description   :

   Date Created      : 2017年10月18日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class ConfigManagerTest {
	@Test
	public void 正常執行() throws Exception {
		File file = new File("D:\\config.json");
		ConfigManager configManager = new ConfigManager();
		List<Config> configList = configManager.ProcessConfigs(file);
		System.out.println(configManager.Count());
		for (Config config : configList) {
			System.out.println(config.getExt());
			System.out.println(config.getLocation());
			System.out.println(config.getSubDirectory());
			System.out.println(config.getUnit());
			System.out.println(config.getRemove());
			System.out.println(config.getHandler());
			System.out.println(config.getDestination());
			System.out.println(config.getDir());
			System.out.println(config.getConnectionString());
		}
	}
}
