package com.example.task;

import java.util.Calendar;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
@EnableScheduling
public class TestTask
{
	@Scheduled(fixedRate = 5000)
	public void run()
	{
		log.info("------------------------ task start = {}", Calendar.getInstance().getTime());
	}
}
