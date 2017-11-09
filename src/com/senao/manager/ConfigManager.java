/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.ConfigManager
   Module Description   :

   Date Created      : 2017年10月18日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao.manager;

import java.util.Arrays;
import java.util.List;

import com.senao.Config;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ConfigManager extends JsonManager<Config>
{
	private final String path = "/com/senao/config.json";

	/**
	 * 將JSON內容轉換成ArrayList
	 * 
	 * @return ArrayList<Config>
	 */
	@Override
	public List<Config> ProcessJsonConfig()
	{
		JSONObject jsonObject = this.GetJsonObject(this.path);
		JSONArray configsArray = jsonObject.optJSONArray("configs");
		for (int i = 0; i < configsArray.size(); i++)
		{
			JSONObject config = (JSONObject) configsArray.get(i);
			JSONArray extArray = config.optJSONArray("ext");
			String[] exts = Arrays.copyOf(extArray.toArray(), extArray.size(), String[].class);

			String location = config.get("location").toString();
			Boolean subDirectory = (Boolean) config.get("subDirectory");
			String unit = config.get("unit").toString();
			Boolean remove = (Boolean) config.get("remove");
			JSONArray handlerArray = config.optJSONArray("handler");
			String[] handlers = Arrays.copyOf(handlerArray.toArray(), handlerArray.size(), String[].class);
			String destination = config.get("destination").toString();
			String dir = config.get("dir").toString();
			String connectionString = config.get("connectionString").toString();
			this.objectList
					.add(new Config(exts, location, subDirectory, unit, remove, handlers, destination, dir, connectionString));
		}
		return this.objectList;
	}
}
