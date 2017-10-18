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
	private List<Schedule> schedules;
	private int Count;

	/**
	 * @return the schedules
	 */
	public List<Schedule> getSchedules() {
		return schedules;
	}

	/**
	 * @param schedules the schedules to set
	 */
	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	/**
	 * @return the count
	 */
	public int Count() {
		this.Count = (schedules == null) ? 0 : schedules.size();
		return Count;
	}

	public List<Schedule> ProcessConfigs(File scheduleFile) throws FileNotFoundException {
		if (!scheduleFile.exists())
			throw new FileNotFoundException();
		this.schedules = new ArrayList<Schedule>();
		JSONParser parser = new JSONParser();
		try {
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

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return schedules;
	}
}
