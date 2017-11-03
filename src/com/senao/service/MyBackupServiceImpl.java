/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.service.MyBackupServiceImpl
   Module Description   :

   Date Created      : 2017年10月24日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.senao.Candidate;
import com.senao.ConfigManager;
import com.senao.JsonManager;
import com.senao.ScheduleManager;
import com.senao.factory.HandlerFactory;
import com.senao.handler.Handler;

/**
 * @author 015336
 */
public class MyBackupServiceImpl implements MyBackupService {

	private List<JsonManager> managers = new ArrayList<JsonManager>();
	private HandlerFactory handlerFactory = new HandlerFactory();

	public MyBackupServiceImpl() {
		this.managers.add(new ConfigManager());
		this.managers.add(new ScheduleManager());
	}

	@Override
	public void ProcessJsonConfigs() throws FileNotFoundException, IOException, ParseException {
		for (JsonManager jsonManager : this.managers) {
			jsonManager.ProcessJsonConfig();
		}
	}

	/**
	 * @return the managers
	 */
	public List<JsonManager> getManagers() {
		return managers;
	}

	/**
	 * @param managers the managers to set
	 */
	public void setManagers(List<JsonManager> managers) {
		this.managers = managers;
	}

	@Override
	public void DoBackup() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Candidate> candidates = this.FindFiles();
		for (Candidate candidate : candidates) {
			this.BroadcastToHandlers(candidate);
		}
	}

	private void BroadcastToHandlers(Candidate candidate)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Handler> handlers = this.FindHandlers(candidate);
		byte[] target = null;
		for (Handler handler : handlers) {
			target = handler.Perform(candidate, target);
		}
	}

	private List<Candidate> FindFiles() {
		List<Candidate> candidateList = new ArrayList<Candidate>();
		// Homework 4
		return candidateList;
	}

	private List<Handler> FindHandlers(Candidate candidate)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Handler> handlers = new ArrayList<Handler>();
		handlers.add(handlerFactory.Create("file"));
		for (String handler : candidate.getConfig().getHandler()) {
			handlers.add(handlerFactory.Create(handler));
		}
		handlers.add(handlerFactory.Create(candidate.getConfig().getDestination()));
		return handlers;
	}

}
