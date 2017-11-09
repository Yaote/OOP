/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.LocalFileFinderTest
   Module Description   :

   Date Created      : 2017年11月8日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao;

import org.junit.Test;

import com.senao.factory.FileFinderFactory;
import com.senao.service.impl.LocalFileFinder;

/**
 * @author 015336
 */
public class LocalFileFinderTest
{
	@Test
	public void main()
	{
		FileFinderFactory fileFinderFactory = new FileFinderFactory();

		Config config = new Config(new String[] { "jpg", "3gp" }, "D:\\Picture", false, "file", false, new String[] {}, "",
				"", "");
		LocalFileFinder localFileFinder = (LocalFileFinder) fileFinderFactory.Create("file", config);
		System.out.println(localFileFinder.getFiles().size());

	}
}
