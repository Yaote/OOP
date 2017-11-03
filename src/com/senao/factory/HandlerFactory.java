/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.factory.HandlerFactory
   Module Description   :

   Date Created      : 2017年10月31日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao.factory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.senao.handler.Handler;

/**
 * @author 015336
 */
public class HandlerFactory {
	private static HashMap<String, String> handlerDictionary = new HashMap<String, String>();
	private final String path = "handler_mapping.json";

	public HandlerFactory() {
		ObjectMapper objectMapper = new ObjectMapper();
		URL url = getClass().getResource(this.path);
		try {
			HandlerFactory.handlerDictionary = objectMapper.readValue(new File(url.getPath()),
					new TypeReference<Map<String, String>>() {
					});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Handler Create(String handlerName)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return (Handler) Class.forName(HandlerFactory.handlerDictionary.get(handlerName).toString()).newInstance();
	}
}
