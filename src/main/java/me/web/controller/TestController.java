package me.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.common.bean.SchedulerRequest;
import me.service.scheduler.SchedulerService;

@RestController
public class TestController {

	@Resource(name = "schedulerService")
	private SchedulerService schedulerService;

	@GetMapping("/schedule")
	String scheduler(HttpServletRequest request) {

		// every 2 seconds
		final SchedulerRequest schedulerRequest = new SchedulerRequest.Builder().id("mySchedulerId")
				.name("My Scheduler name").cronExpression("0/2 * * * * ?").build();

		schedulerService.schedule(schedulerRequest);

		return "scheduled";
	}

	@GetMapping("/shutdown")
	String shutdown(HttpServletRequest request) {

		// every 2 seconds
		final SchedulerRequest schedulerRequest = new SchedulerRequest.Builder().id("mySchedulerId")
				.name("My Scheduler name").build();

		schedulerService.shutdown(schedulerRequest);

		return "shutdown completed";
	}
}
