package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.example.task.CronTaskJob;

@Configuration
public class ScheduleConfiguration implements InitializingBean {

	private static final Logger LOG = LoggerFactory.getLogger(ScheduleConfiguration.class);
	
	@Bean("scheduledTaskRegistrar")
	public ScheduledTaskRegistrar scheduledTaskRegistrar() {
		
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(20);
		scheduler.setThreadNamePrefix("task-");
		scheduler.afterPropertiesSet();
		
		
		ScheduledTaskRegistrar scheduledTaskRegistar = new ScheduledTaskRegistrar();
        scheduledTaskRegistar.setTaskScheduler(scheduler);
//		scheduledTaskRegistar.addCronTask(cronTask());
        scheduledTaskRegistar.scheduleCronTask(cronTask());
        scheduledTaskRegistar.afterPropertiesSet();
        
		
		return scheduledTaskRegistar;
	}
	
	private CronTask cronTask() {
		
		CronTaskJob job = new CronTaskJob();
		return new CronTask(job, "0 0 15 * * ?");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		LOG.debug("init ScheduleConfiguration");
	}
}
