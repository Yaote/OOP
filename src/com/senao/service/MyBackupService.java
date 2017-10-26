/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.service.MyBackupService
   Module Description   :

   Date Created      : 2017年10月24日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.senao.ConfigManager;
import com.senao.JsonManager;
import com.senao.ScheduleManager;

/**
 * @author 015336
 */
public class MyBackupService implements IMyBackupService {

	private List<JsonManager> managers = new ArrayList<JsonManager>();

	public MyBackupService() {
		this.managers.add(new ConfigManager());
		this.managers.add(new ScheduleManager());
	}

	@Override
	public void ProcessJsonConfigs() {
		for (JsonManager jsonManager : this.managers) {
			try {
				jsonManager.ProcessJsonConfig();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return the managers
	 */
	public List<JsonManager> getManagers() {
		return managers;
	}

	/**
	 * @param managers the managers to set
	 */
	public void setManagers(List<JsonManager> managers) {
		this.managers = managers;
	}

}
