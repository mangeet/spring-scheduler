package me.service.scheduler.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import me.common.bean.SchedulerRequest;
import me.common.util.BeanFactoryUtil;
import me.service.scheduler.SchedulerService;

@Component(value = "schedulerService")
public class SchedulerServiceImpl implements SchedulerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerServiceImpl.class);

	@Override
	public void schedule(SchedulerRequest schedulerRequest) {

		LOGGER.info("Scheduling the task to execute job of id {}.", schedulerRequest.getId());

		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setWaitForTasksToCompleteOnShutdown(true);

		final CronTrigger trigger = new CronTrigger(schedulerRequest.getCronExpression());
		final Runnable task = getTask(schedulerRequest);

		scheduler.initialize();
		BeanFactoryUtil.registerSingleton(schedulerRequest.getId(), scheduler);

		scheduler.schedule(task, trigger);

		LOGGER.info("Task is scheduled successfully.");
	}

	@Override
	public void shutdown(SchedulerRequest schedulerRequest) {

		final ThreadPoolTaskScheduler scheduler = BeanFactoryUtil.getDefaultListableBeanFactory()
				.getBean(schedulerRequest.getId(), ThreadPoolTaskScheduler.class);
		scheduler.shutdown();
		
		LOGGER.info("Task has been shutdown");
	}

	private Runnable getTask(final SchedulerRequest schedulerRequest) {

		return new Runnable() {

			@Override
			public void run() {
				LOGGER.info("Executing task of id {}.", schedulerRequest.getId());

				// TODO:: execute your job here
			}
		};
	}

}
