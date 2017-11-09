/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.ScheduleManagerTest
   Module Description   :

   Date Created      : 2017年10月18日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao;

import java.util.List;

import org.junit.Test;

import com.senao.manager.ScheduleManager;

public class ScheduleManagerTest
{
	@Test
	public void 正常執行() throws Exception
	{
		ScheduleManager scheduleManager = new ScheduleManager();
		List<Schedule> scheduleList = scheduleManager.ProcessJsonConfig();
		System.out.println(scheduleManager.Count());
		for (Schedule schedule : scheduleList)
		{
			for (String ext : schedule.getExt())
			{
				System.out.println(ext);
			}
			System.out.println(schedule.getTime());
			System.out.println(schedule.getInterval());
		}
	}
}
