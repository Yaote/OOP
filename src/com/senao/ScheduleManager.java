/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.ScheduleManager
   Module Description   :

   Date Created      : 2017年10月18日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ScheduleManager {
	private List<Schedule> schedules = new ArrayList<Schedule>();

	/**
	 * 取得ArrayList的筆數
	 * 
	 * @return the count
	 */
	public int Count() {
		return this.schedules.size();
	}

	/**
	 * 將JSON內容轉換成ArrayList
	 * 
	 * @param scheduleFile 檔案路徑
	 * @return ArrayList<Config>
	 * @throws FileNotFoundException
	 */
	public List<Schedule> ProcessConfigs(File scheduleFile) throws FileNotFoundException, IOException, ParseException {
		this.schedules = new ArrayList<Schedule>();
		JSONParser parser = new JSONParser();
		// 將實體檔案內容轉換成JSONObject
		JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(scheduleFile));
		// loop array
		JSONArray configsArray = (JSONArray) jsonObject.get("schedules");
		for (int i = 0; i < configsArray.size(); i++) {
			JSONObject config = (JSONObject) configsArray.get(i);
			String ext = config.get("ext").toString();
			String time = config.get("time").toString();
			String interval = config.get("interval").toString();
			this.schedules.add(new Schedule(ext, time, interval));
		}
		return this.schedules;
	}
}
