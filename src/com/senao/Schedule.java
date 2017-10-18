/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.Schedule
   Module Description   :
   Date Created      : 2017年10月18日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao;

public class Schedule {

	/**
	 * Schedule constructor
	 * 
	 * @param ext 排程所處理的檔案格式
	 * @param time 排程所處理的時間
	 * @param interval 排程執行的間隔
	 */
	public Schedule(String ext, String time, String interval) {
		super();
		this.ext = ext;
		this.time = time;
		this.interval = interval;
	}

	/**
	 * 排程所處理的檔案格式
	 */
	private String ext;

	/**
	 * 排程所處理的時間
	 */
	private String time;

	/**
	 * 排程執行的間隔
	 */
	private String interval;

	/**
	 * @return the ext
	 */
	public String getExt() {
		return ext;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @return the interval
	 */
	public String getInterval() {
		return interval;
	}

}
