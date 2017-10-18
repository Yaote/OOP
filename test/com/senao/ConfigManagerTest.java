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
	public void main() throws Exception {
		File file = new File("D:\\config.json");
		ConfigManager configManager = new ConfigManager();
		List<Config> configList = configManager.ProcessConfigs(file);
		System.out.println(configManager.Count());
	}
}
