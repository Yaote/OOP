/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.service.LocalFileFinder
   Module Description   :

   Date Created      : 2017年11月7日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao.service.impl;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senao.Candidate;
import com.senao.Config;

/**
 * @author 015336
 */
public class LocalFileFinder extends AbstractFileFinder<Candidate>
{
	private Logger logger = LogManager.getLogger(LocalFileFinder.class);

	public LocalFileFinder()
	{

	}

	public LocalFileFinder(Config config)
	{
		// 判斷子目錄是否也要處理
		if (config.getSubDirectory())
		{
			// 指定子目錄也要一起處理
			this.files = this.GetSubDirectoryFiles(config);
		} else
		{
			// 只針對副檔名處理
			this.files = this.getFiles(config.getLocation(), config.getExt());
		}
	}

	/**
	 * 取得包含子目錄底下的所有檔案
	 * 
	 * @param config
	 * @return ArrayList<File>
	 */
	private List<File> GetSubDirectoryFiles(Config config)
	{
		List<File> files = new ArrayList<File>();
		if (StringUtils.isNotBlank(config.getLocation()))
		{
			files.addAll(this.getFiles(config.getLocation(), config.getExt()));
			files.addAll(this.listAllFiles(config.getLocation()));
		}
		return files;
	}

	/**
	 * 列出指定目錄下的所有檔案
	 * 
	 * @param directoryName
	 * @return ArrayList<File>
	 */
	private List<File> listAllFiles(String directoryName)
	{
		// // 防呆,若空的就不往下跑
		// if (StringUtils.isBlank(directoryName))
		// {
		// return null;
		// }
		File directory = new File(directoryName);
		if (!directory.exists())
		{
			return null;
		}

		for (File file : directory.listFiles())
		{
			if (file.isFile())
			{ // 若是檔案則加入清單內
				files.add(file);
			} else if (file.isDirectory())
			{// 若是資料夾則再跑一次撈取目錄下的檔案Function
				files.addAll(this.listAllFiles(file.getAbsolutePath()));
			}
		}
		return files;
	}

	/**
	 * 過濾指定的副檔名
	 * 
	 * @param directory
	 * @param extension 副檔名
	 * @return ArrayList<File>
	 */
	private List<File> getFiles(String directory, String[] extension)
	{
		// 指定要讀取的路徑
		File dir = new File(directory);
		File[] files = null;
		// 建立檔案過濾器
		FilenameFilter filter = new FilenameFilter()
		{
			@Override
			public boolean accept(File dir, String filename)
			{
				boolean isAccepted = false;
				for (int i = 0; i < extension.length; i++)
				{
					if (filename.indexOf(extension[i]) != -1)
					{
						isAccepted = true;
						return isAccepted;
					}
				}
				return isAccepted;
			}
		};
		// 若有指定副檔名則過濾
		if (extension.length > 0)
		{
			files = dir.listFiles(filter);
		} else
		{
			// 路徑下的檔案都回傳
			files = dir.listFiles();
		}
		if (files != null && files.length > 0)
			return Arrays.asList(files);
		return null;
	}

	@Override
	protected Candidate CreateCandidate(String fileName)
	{
		// TODO 完全不曉得這裡要做啥
		Candidate candidate = new Candidate();
		candidate.setName(fileName);
		return candidate;
	}

}
