/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.Config
   Module Description   :

   Date Created      : 2017年10月18日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao;

public class Config {

	/**
	 * Config constructor
	 * 
	 * @param ext 檔案格式
	 * @param location 要備份檔案的目錄
	 * @param subDirectory 是否處理子目錄，true : 處理子目錄；false : 不 處理子目錄
	 * @param unit 備份單位，file : 以單一檔案為處理單位；directory : 以整個目錄為處理單位
	 * @param remove 處理完是否刪除檔案，true : 刪除；false : 不刪除
	 * @param handler zip : 壓縮；encode : 加密
	 * @param destination 處理後要儲存到什麼地方，directory : 目錄；db : 資料庫
	 * @param dir 處理後的目錄
	 * @param connectionString 資料庫連接字串
	 */
	public Config(String ext, String location, String subDirectory, String unit, String remove, String handler,
			String destination, String dir, String connectionString) {
		super();
		this.ext = ext;
		this.location = location;
		this.subDirectory = subDirectory;
		this.unit = unit;
		this.remove = remove;
		this.handler = handler;
		this.destination = destination;
		this.dir = dir;
		this.connectionString = connectionString;
	}

	/**
	 * 檔案格式
	 */
	private String ext;

	/**
	 * 要備份檔案的目錄
	 */
	private String location;

	/**
	 * 是否處理子目錄，true : 處理子目錄；false : 不 處理子目錄
	 */
	private String subDirectory;

	/**
	 * 備份單位，file : 以單一檔案為處理單位；directory : 以整個目錄為處理單位
	 */
	private String unit;

	/**
	 * 處理完是否刪除檔案，true : 刪除；false : 不刪除
	 */
	private String remove;

	/**
	 * zip : 壓縮；encode : 加密
	 */
	private String handler;

	/**
	 * 處理後要儲存到什麼地方，directory : 目錄；db : 資料庫
	 */
	private String destination;

	/**
	 * 處理後的目錄
	 */
	private String dir;

	/**
	 * 設定資料庫連接字串
	 */
	private String connectionString;

	/**
	 * @return the ext
	 */
	public String getExt() {
		return ext;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @return the subDirectory
	 */
	public String getSubDirectory() {
		return subDirectory;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @return the remove
	 */
	public String getRemove() {
		return remove;
	}

	/**
	 * @return the handler
	 */
	public String getHandler() {
		return handler;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @return the dir
	 */
	public String getDir() {
		return dir;
	}

	/**
	 * @return the connectionString
	 */
	public String getConnectionString() {
		return connectionString;
	}

}
