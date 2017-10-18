/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.ConfigManager
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

public class ConfigManager {
	private List<Config> configs = new ArrayList<Config>();

	/**
	 * 取得ArrayList的筆數
	 * 
	 * @return the count
	 */
	public int Count() {
		return this.configs.size();
	}

	/**
	 * 將JSON內容轉換成ArrayList
	 * 
	 * @param configFile 檔案路徑
	 * @return ArrayList<Config>
	 * @throws FileNotFoundException, IOException, ParseException
	 */
	public List<Config> ProcessConfigs(File configFile) throws FileNotFoundException, IOException, ParseException {
		this.configs = new ArrayList<Config>();
		JSONParser parser = new JSONParser();
		// 將實體檔案內容轉換成JSONObject
		JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(configFile));
		// loop array
		JSONArray configsArray = (JSONArray) jsonObject.get("configs");
		for (int i = 0; i < configsArray.size(); i++) {
			JSONObject config = (JSONObject) configsArray.get(i);
			String ext = config.get("ext").toString();
			String location = config.get("location").toString();
			String subDirectory = config.get("subDirectory").toString();
			String unit = config.get("unit").toString();
			String remove = config.get("remove").toString();
			String handler = config.get("handler").toString();
			String destination = config.get("destination").toString();
			String dir = config.get("dir").toString();
			String connectionString = config.get("connectionString").toString();
			this.configs
					.add(new Config(ext, location, subDirectory, unit, remove, handler, destination, dir, connectionString));
		}
		return this.configs;
	}
}
