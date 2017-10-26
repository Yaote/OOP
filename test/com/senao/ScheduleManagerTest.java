/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.ScheduleManagerTest
   Module Description   :

   Date Created      : 2017年10月18日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class ScheduleManagerTest {
	@Test
	public void 正常執行() throws Exception {
		File file = new File("D:\\schedule.json");
		ScheduleManager scheduleManager = new ScheduleManager();
		List<Schedule> scheduleList = (List<Schedule>) scheduleManager.ProcessJsonConfig();
		System.out.println(scheduleManager.Count());
		for (Schedule schedule : scheduleList) {
			System.out.println(schedule.getExt());
			System.out.println(schedule.getTime());
			System.out.println(schedule.getInterval());
		}
	}
}
