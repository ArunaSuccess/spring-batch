package com.spring.batch.model;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	@Autowired
	  public JobBuilderFactory jobBuilderFactory;

	  @Autowired
	  public StepBuilderFactory stepBuilderFactory;
	  
	  @Bean
	  public FlatFileItemReader<Stock> reader() {
	    return new FlatFileItemReaderBuilder<Stock>()
	      .name("stockItemReader")
	      .linesToSkip(1)
	      .resource(new ClassPathResource("sample-stock-data.csv"))
	      .delimited()
	      .names(new String[]{"ticker", "boughtPrice", "shares", "purchaseAmt", "currentPrice", "glReported", "glCalculated"})
	      .fieldSetMapper(new BeanWrapperFieldSetMapper<Stock>() {{
	        setTargetType(Stock.class);
	      }})
	      .build();
	  }

	  @Bean
	  public StockItemProcessor processor() {
	    return new StockItemProcessor();
	  }

	  @Bean
	  public JdbcBatchItemWriter<Stock> writer(DataSource dataSource) {
	    return new JdbcBatchItemWriterBuilder<Stock>()
	      .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	      .sql("INSERT INTO tbl_stocks (ticker, bought_price, shares, purchase_amt, current_price, gl_reported, gl_calculated) VALUES "
	      		+ "(:ticker, :boughtPrice, :shares, :purchaseAmt, :currentPrice, :glReported, :glCalculated)")
	      .dataSource(dataSource)
	      .build();
	  }

	  @Bean
	  public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
	    return jobBuilderFactory.get("importUserJob")
	      .incrementer(new RunIdIncrementer())
	      .listener(listener)
	      .flow(step1)
	      .end()
	      .build();
	  }

	  @Bean
	  public Step step1(JdbcBatchItemWriter<Stock> writer) {
	    return stepBuilderFactory.get("step1")
	      .<Stock, Stock> chunk(10)
	      .reader(reader())
	      .processor(processor())
	      .writer(writer)
	      .build();
	  }
}
