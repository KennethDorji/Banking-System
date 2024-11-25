package com.state.bank.jobs;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BankScheduler {

	@Scheduled(cron ="*/1 * * * * *")
	public void name() {
		//System.out.println("Batch Job Output :"+LocalDateTime.now());
		//log.info("Batch Job Output : {}",LocalDateTime.now());
	}
}
