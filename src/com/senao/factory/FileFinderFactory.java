/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.factory.FileFinderFactory
   Module Description   :

   Date Created      : 2017年11月7日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao.factory;

import com.senao.Config;
import com.senao.service.FileFinder;
import com.senao.service.impl.LocalFileFinder;

/**
 * @author 015336
 */
public class FileFinderFactory
{

	public FileFinder Create(String finder, Config config)
	{
		if ("file".equals(finder))
		{
			return new LocalFileFinder(config);
		}
		return null;
	}
}
