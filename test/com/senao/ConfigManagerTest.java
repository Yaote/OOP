/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.ConfigManagerTest
   Module Description   :

   Date Created      : 2017年10月18日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao;

import java.util.List;

import org.junit.Test;

import com.senao.manager.ConfigManager;

public class ConfigManagerTest
{
	@Test
	public void 正常執行() throws Exception
	{
		ConfigManager configManager = new ConfigManager();
		List<Config> configList = configManager.ProcessJsonConfig();
		System.out.println(configManager.Count());

		for (Config config : configList)
		{
			for (String ext : config.getExt())
			{
				System.out.println(ext);
			}
			System.out.println(config.getLocation());
			System.out.println(config.getSubDirectory());
			System.out.println(config.getUnit());
			System.out.println(config.getRemove());
			for (String handler : config.getHandler())
			{
				System.out.println(handler);
			}
			System.out.println(config.getDestination());
			System.out.println(config.getDir());
			System.out.println(config.getConnectionString());
		}
	}
}
