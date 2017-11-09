/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.service.MyBackupService
   Module Description   :

   Date Created      : 2017年10月24日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao.service;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author 015336
 */
public interface MyBackupService
{
	/**
	 * 將實體設定檔讀進系統
	 */
	public void ProcessJsonConfigs() throws FileNotFoundException, IOException;

	/**
	 * 執行備份
	 */
	public void DoBackup() throws InstantiationException, IllegalAccessException, ClassNotFoundException;
}
