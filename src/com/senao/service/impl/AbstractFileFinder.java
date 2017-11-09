/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.service.AbstractFileFinder
   Module Description   :

   Date Created      : 2017年11月7日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.senao.Config;
import com.senao.service.FileFinder;

/**
 * @author 015336
 */
public abstract class AbstractFileFinder<T> implements FileFinder<T>
{
	protected Config config;
	protected List<File> files = new ArrayList<File>();
	protected int index = 0;

	protected AbstractFileFinder()
	{
	}

	protected AbstractFileFinder(Config config)
	{
		if (config != null)
		{
			this.config = config;
		}
	}

	public T Current;

	/**
	 * @return the current
	 */
	public T getCurrent()
	{
		if (this.files.size() > 0)
		{
			this.Current = this.CreateCandidate(this.files.get(this.index).getName());
		}
		return this.Current;
	}

	/**
	 * @param current the current to set
	 */
	public void setCurrent(T current)
	{
		this.Current = current;
	}

	public void Rest()
	{
		this.index = -1;
	}

	@Override
	public Iterator<T> iterator()
	{
		return this;
	}

	@Override
	public boolean hasNext()
	{
		return (this.files.size() > 0 && (this.files.size() < (index++)));
	}

	@Override
	public T next()
	{
		if (this.hasNext())
		{
			this.index += 1;
			return this.CreateCandidate(files.get(this.index).getName());
		}
		return null;
	}

	protected abstract T CreateCandidate(String fileName);

	/**
	 * @return the config
	 */
	public Config getConfig()
	{
		return config;
	}

	/**
	 * @param config the config to set
	 */
	public void setConfig(Config config)
	{
		this.config = config;
	}

	/**
	 * @return the files
	 */
	public List<File> getFiles()
	{
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(List<File> files)
	{
		this.files = files;
	}

	/**
	 * @return the index
	 */
	public int getIndex()
	{
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index)
	{
		this.index = index;
	}

}
