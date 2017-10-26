/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.JsonManager
   Module Description   :

   Date Created      : 2017年10月24日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author 015336
 */
public abstract class JsonManager<T> {
	protected List<T> objectList = new ArrayList<T>();

	/**
	 * 取得ArrayList的筆數
	 * 
	 * @return the count
	 */
	protected int Count() {
		return objectList.size();
	}

	public abstract Object ProcessJsonConfig() throws FileNotFoundException, IOException, ParseException;

	protected JSONObject GetJsonObject(String filePath) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		// 將實體檔案內容轉換成JSONObject
		JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(filePath));
		return jsonObject;
	}
}
