package com.javahonk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApplication {
	
	private static final Logger logger = LogManager.getLogger(MainApplication.class.getName());

	public static void main(String[] args) {
		
		logger.info("EventBus Spring application starting...");

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
		
		((AbstractApplicationContext) applicationContext).close();

	}

}
