package com.imaginea.Launcher;

import static org.junit.Assert.*;

import java.util.concurrent.Executor;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class SpringAsyncCollatorLauncher {

	/**
	 * Class used to launch the application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringAsyncCollatorLauncher.class,args);
		
	}

	/**
	 * Changes has been made as per requirement 
	 * 
	 * @return
	 */
	@Bean
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(4);
		executor.setMaxPoolSize(4);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("Api Caller2-");
		executor.initialize();
		
		return executor;
	}
	
	
	/**
	 * This is a spring test method 
	 * 
	 * @throws Exception
	 */
	public void testName() throws Exception {
		
	}
	
	
}
