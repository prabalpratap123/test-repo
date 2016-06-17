package com.progen.quartz;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;

import com.progen.controller.MainController;


public class QuartzSchedulerCronExpressionExample {
	static final Logger logger = Logger.getLogger(QuartzSchedulerCronExpressionExample.class); // register class with logger

	public static void main(String[] args) throws Exception {
		QuartzSchedulerCronExpressionExample quartzSchedulerExample = new QuartzSchedulerCronExpressionExample();
		quartzSchedulerExample.fireJob();
	}

	public static void startScheduler() throws Exception {
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		logger.info("startScheduler   Called");
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		QuartzSchedulerCronExpressionExample quartzSchedulerExample = new QuartzSchedulerCronExpressionExample();
		quartzSchedulerExample.fireJob();
		logger.info("startScheduler   fired");
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}



	public void fireJob() throws SchedulerException, InterruptedException {
		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
		Scheduler scheduler = schedFact.getScheduler();
		scheduler.start();

		// define the job and tie it to our HelloJob class
		JobBuilder jobBuilder = JobBuilder.newJob(MyJob.class);

		JobDetail jobDetail = jobBuilder.usingJobData("example", "com.javacodegeeks.quartz.QuartzSchedulerListenerExample")
				.withIdentity("myJob", "group1")
				.build();

		System.out.println("Current time: " + new Date());

		// Tell quartz to schedule the job using our trigger
		// Fire at current time + 1 min every day
		scheduler.scheduleJob(jobDetail, CronExpressionsExample.fireAt1015MinMonToFri());

//		scheduler.scheduleJob(jobDetail, CronExpressionsExample.fireAfterTwoMinFrom7_46To7_58());
	}
}
