package com.example.task;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CronTaskJob implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(CronTaskJob.class);

	@Override
	public void run() {
		LOG.info("------------------------ CronTaskJob execute = {}", Calendar.getInstance().getTime());
	}
}
