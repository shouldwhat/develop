package com.example.task;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


//@Slf4j
@Component
@EnableScheduling
public class TestTask
{
	private static final Logger LOG = LoggerFactory.getLogger(TestTask.class);
	
	@Scheduled(fixedRate = 5000)
	public void run()
	{
		LOG.info("------------------------ TestTask execute = {}", Calendar.getInstance().getTime());
	}
}
