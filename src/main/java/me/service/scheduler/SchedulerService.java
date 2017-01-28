package me.service.scheduler;

import me.common.bean.SchedulerRequest;

public interface SchedulerService {

	/**
	 * Schedules a task at specified interval.
	 * 
	 * @param schedulerRequest
	 */
	void schedule(final SchedulerRequest schedulerRequest);

	/**
	 * Shutdown a scheduled task.
	 * 
	 * @param schedulerRequest
	 */
	void shutdown(final SchedulerRequest schedulerRequest);

}
