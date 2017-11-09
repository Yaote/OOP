/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.ScheduleManager
   Module Description   :

   Date Created      : 2017年10月18日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao.manager;

import java.util.Arrays;
import java.util.List;

import com.senao.Schedule;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ScheduleManager extends JsonManager<Schedule>
{
	private final String path = "/com/senao/schedule.json";// 指定檔案路徑

	/**
	 * 將JSON內容轉換成ArrayList
	 * 
	 * @return ArrayList<Schedule>
	 */
	@Override
	public List<Schedule> ProcessJsonConfig()
	{
		JSONObject jsonObject = this.GetJsonObject(this.path);
		JSONArray schedulesArray = jsonObject.optJSONArray("schedules");
		for (int i = 0; i < schedulesArray.size(); i++)
		{
			JSONObject schedule = (JSONObject) schedulesArray.get(i);
			JSONArray extArray = schedule.optJSONArray("ext");
			String[] exts = Arrays.copyOf(extArray.toArray(), extArray.size(), String[].class);
			String time = schedule.get("time").toString();
			String interval = schedule.get("interval").toString();
			this.objectList.add(new Schedule(exts, time, interval));
		}
		return this.objectList;
	}
}
