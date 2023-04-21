package com.inops.computation;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

	ComputeService computeService;

	Logger logger = LoggerFactory.getLogger(Scheduler.class);

	public Scheduler(ComputeService computeService) {
		super();
		this.computeService = computeService;
	}

	 @Scheduled(fixedDelay = 600000, initialDelay = 3000)
	//@Scheduled(fixedDelay = 10000, initialDelay = 1000)
	public void cronJobSch() {
		logger.info("Computation started at {}", LocalDate.now().toString());
		computeService.compute();
		logger.info("Computation ended at {}", LocalDate.now().toString());

	}
}
