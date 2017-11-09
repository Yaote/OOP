/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.ZipHandler
   Module Description   :

   Date Created      : 2017年10月31日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao.handler.impl;

import java.io.ByteArrayOutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import com.senao.Candidate;

/**
 * @author 015336
 */
public class ZipHandler extends AbstractHandler
{

	@Override
	public byte[] Perform(Candidate candidate, byte[] target)
	{
		byte[] result = target;
		if (target != null)
		{
			result = this.ZipData(candidate, target);
		}
		return result;
	}

	private byte[] ZipData(Candidate candidate, byte[] target)
	{
		Deflater compressor = new Deflater(Deflater.DEFAULT_COMPRESSION, false);
		compressor.setInput(target);
		compressor.finish();
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		byte[] readBuffer = new byte[1024];
		int readCount = 0;

		while (!compressor.finished())
		{
			readCount = compressor.deflate(readBuffer);
			if (readCount > 0)
			{
				bao.write(readBuffer, 0, readCount);
			}
		}

		compressor.end();
		return bao.toByteArray();
	}

	private byte[] UnZipData(Candidate candidate, byte[] target) throws DataFormatException
	{
		Inflater decompressor = new Inflater(false);
		decompressor.setInput(target);
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		byte[] readBuffer = new byte[1024];
		int readCount = 0;

		while (!decompressor.finished())
		{
			readCount = decompressor.inflate(readBuffer);
			if (readCount > 0)
			{
				bao.write(readBuffer, 0, readCount);
			}
		}

		decompressor.end();
		return bao.toByteArray();
	}
}
