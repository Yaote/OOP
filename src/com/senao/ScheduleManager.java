/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.ScheduleManager
   Module Description   :

   Date Created      : 2017年10月18日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class ScheduleManager extends JsonManager {
	private final String path = "/schedule.json";// 指定檔案路徑

	/**
	 * 將JSON內容轉換成ArrayList
	 * 
	 * @return ArrayList<Config>
	 * @throws ParseException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Override
	public Object ProcessJsonConfig() throws FileNotFoundException, IOException, ParseException {
		JSONObject jsonObject = this.GetJsonObject(this.path);
		JSONArray configsArray = (JSONArray) jsonObject.get("schedules");
		for (int i = 0; i < configsArray.size(); i++) {
			JSONObject config = (JSONObject) configsArray.get(i);
			String ext = config.get("ext").toString();
			String time = config.get("time").toString();
			String interval = config.get("interval").toString();
			this.objectList.add(new Schedule(ext, time, interval));
		}
		return this.objectList;
	}
}
