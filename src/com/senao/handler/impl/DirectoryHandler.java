/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.DirectoryHandler
   Module Description   :

   Date Created      : 2017年10月31日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao.handler.impl;

import java.io.FileOutputStream;
import java.io.IOException;

import com.senao.Candidate;

/**
 * @author 015336
 */
public class DirectoryHandler extends AbstractHandler
{

	@Override
	public byte[] Perform(Candidate candidate, byte[] target)
	{
		byte[] result = target;
		if (target != null)
		{
			try
			{
				result = this.CopyToDirectory(candidate, target);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	private byte[] CopyToDirectory(Candidate candidate, byte[] target) throws IOException
	{
		FileOutputStream fileOuputStream = new FileOutputStream(
				candidate.getConfig().getDestination() + "/" + candidate.getName());
		fileOuputStream.write(target);
		fileOuputStream.close();
		return target;
	}
}
