/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.JsonManager
   Module Description   :

   Date Created      : 2017年10月24日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao.manager;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;

/**
 * @author 015336
 */
public abstract class JsonManager<T>
{
	protected List<T> objectList = new ArrayList<T>();

	/**
	 * 取得ArrayList的筆數
	 * 
	 * @return the count
	 */
	public int Count()
	{
		return objectList.size();
	}

	public abstract List<T> ProcessJsonConfig();

	protected JSONObject GetJsonObject(String filePath)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		URL url = getClass().getResource(filePath);
		JSONObject jsonObject = null;
		try
		{
			jsonObject = objectMapper.readValue(new File(url.getPath()), new TypeReference<JSONObject>()
			{
			});
		} catch (JsonParseException e)
		{
			e.printStackTrace();
		} catch (JsonMappingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return jsonObject;
	}
}
