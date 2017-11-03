/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.ConfigManager
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

public class ConfigManager extends JsonManager<Config> {
	private final String path = "/config.json";

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
		// loop array
		JSONArray configsArray = (JSONArray) jsonObject.get("configs");
		for (int i = 0; i < configsArray.size(); i++) {
			JSONObject config = (JSONObject) configsArray.get(i);
			String ext = config.get("ext").toString();
			String location = config.get("location").toString();
			String subDirectory = config.get("subDirectory").toString();
			String unit = config.get("unit").toString();
			String remove = config.get("remove").toString();
			String[] handler = (String[]) config.get("handler");
			String destination = config.get("destination").toString();
			String dir = config.get("dir").toString();
			String connectionString = config.get("connectionString").toString();
			this.objectList
					.add(new Config(ext, location, subDirectory, unit, remove, handler, destination, dir, connectionString));
		}
		return this.objectList;
	}
}
