/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.FileHandler
   Module Description   :

   Date Created      : 2017年10月31日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao.handler.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.senao.Candidate;

/**
 * @author 015336
 */
public class FileHandler extends AbstractHandler
{

	@Override
	public byte[] Perform(Candidate candidate, byte[] target)
	{
		byte[] result = target;
		try
		{
			if (target == null)
			{

				result = this.ConvertFileToByteArray(candidate);

			} else
			{
				this.ConvertByteArrayToFile(candidate, target);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 將檔案轉換成Byte[]
	 * 
	 * @param candidate
	 * @return byte[]
	 */
	private byte[] ConvertFileToByteArray(Candidate candidate) throws IOException
	{
		byte[] target = null;
		FileOutputStream fileOuputStream;
		fileOuputStream = new FileOutputStream(candidate.getConfig().getLocation() + "/" + candidate.getName());
		fileOuputStream.write(target);
		fileOuputStream.close();
		return target;
	}

	/**
	 * 將Byte[]轉換成File檔案
	 * 
	 * @param candidate
	 * @param target
	 * @throws IOException
	 */
	private void ConvertByteArrayToFile(Candidate candidate, byte[] target) throws IOException
	{
		File outputFile = new File(candidate.getConfig().getDestination() + candidate.getName());
		FileOutputStream fileOuputStream = new FileOutputStream(outputFile);
		fileOuputStream.write(target);
		fileOuputStream.close();
	}
}
