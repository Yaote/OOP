/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.Candidate
   Module Description   :

   Date Created      : 2017年10月31日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao;

import java.util.Date;

/**
 * @author 015336
 */
public class Candidate {
	private Config config;
	private Date fileDateTime;
	private String name;
	private String processName;
	private int size;

	/**
	 * @return the config
	 */
	public Config getConfig() {
		return config;
	}

	/**
	 * @param config the config to set
	 */
	public void setConfig(Config config) {
		this.config = config;
	}

	/**
	 * @return the fileDateTime
	 */
	public Date getFileDateTime() {
		return fileDateTime;
	}

	/**
	 * @param fileDateTime the fileDateTime to set
	 */
	public void setFileDateTime(Date fileDateTime) {
		this.fileDateTime = fileDateTime;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the processName
	 */
	public String getProcessName() {
		return processName;
	}

	/**
	 * @param processName the processName to set
	 */
	public void setProcessName(String processName) {
		this.processName = processName;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

}
