package com.spring.batch.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");

			jdbcTemplate.query("SELECT ticker, bought_price, shares, purchase_amt, current_price, gl_reported ,gl_calculated FROM TBL_STOCKS",
				(rs, row) -> new Stock(
						rs.getString(1),
						rs.getDouble(2),
						rs.getDouble(3),
						rs.getDouble(4),
						rs.getDouble(5),
						rs.getDouble(6),
						rs.getDouble(7))
			).forEach(stock -> log.info("Found <" + stock + "> in the database."));
		}
	}
}
