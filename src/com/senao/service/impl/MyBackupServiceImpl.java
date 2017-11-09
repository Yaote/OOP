/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.service.MyBackupServiceImpl
   Module Description   :

   Date Created      : 2017年10月24日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senao.Candidate;
import com.senao.Config;
import com.senao.factory.FileFinderFactory;
import com.senao.factory.HandlerFactory;
import com.senao.handler.Handler;
import com.senao.manager.ConfigManager;
import com.senao.manager.JsonManager;
import com.senao.manager.ScheduleManager;
import com.senao.service.FileFinder;
import com.senao.service.MyBackupService;

/**
 * @author 015336
 */
public class MyBackupServiceImpl implements MyBackupService
{
	private Logger logger = LogManager.getLogger(MyBackupServiceImpl.class);
	private List<JsonManager> managers = new ArrayList<JsonManager>();
	private HandlerFactory handlerFactory = new HandlerFactory();
	private List<Object> lists = new ArrayList<Object>();

	public MyBackupServiceImpl()
	{
		this.managers.add(new ConfigManager());
		this.managers.add(new ScheduleManager());
		this.lists = new ArrayList<Object>();
	}

	@Override
	public void ProcessJsonConfigs() throws FileNotFoundException, IOException
	{
		for (JsonManager jsonManager : this.managers)
		{
			lists.addAll(jsonManager.ProcessJsonConfig());
		}
	}

	@Override
	public void DoBackup() throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		for (Object obj : this.lists)
		{
			if (obj instanceof Config)
			{
				Config config = (Config) obj;
				logger.info(config.toString());
				FileFinder fileFinder = new FileFinderFactory().Create(config.getUnit(), config);
				// List<Candidate> candidates = this.FindFiles();
				// for (Candidate candidate : candidates)
				// {
				// this.BroadcastToHandlers(candidate);
				// }
			}

		}
	}

	private void BroadcastToHandlers(Candidate candidate)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		List<Handler> handlers = this.FindHandlers(candidate);
		byte[] target = null;
		for (Handler handler : handlers)
		{
			target = handler.Perform(candidate, target);
		}
	}

	private List<Candidate> FindFiles()
	{
		List<Candidate> candidateList = new ArrayList<Candidate>();
		// Homework 4
		return candidateList;
	}

	private List<Handler> FindHandlers(Candidate candidate)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		List<Handler> handlers = new ArrayList<Handler>();
		handlers.add(handlerFactory.Create("file"));
		for (String handler : candidate.getConfig().getHandler())
		{
			handlers.add(handlerFactory.Create(handler));
		}
		handlers.add(handlerFactory.Create(candidate.getConfig().getDestination()));
		return handlers;
	}

	/**
	 * @return the lists
	 */
	public List<Object> getLists()
	{
		return lists;
	}

	/**
	 * @param lists the lists to set
	 */
	public void setLists(List<Object> lists)
	{
		this.lists = lists;
	}

	/**
	 * @return the managers
	 */
	public List<JsonManager> getManagers()
	{
		return managers;
	}

	/**
	 * @param managers the managers to set
	 */
	public void setManagers(List<JsonManager> managers)
	{
		this.managers = managers;
	}
}
