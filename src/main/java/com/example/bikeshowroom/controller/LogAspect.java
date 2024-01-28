package com.example.bikeshowroom.controller;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	
	private final Logger log=LoggerFactory.getLogger(LogAspect.class);         // logger is I-orjsl and then in loggerfactory-same orjsl
	
	@Before("execution (public String com.example.bikeshowroom.controller.BikeController.bikeViewPage(..))")   // this execution name is have to bee like path folder and say each and evry way and final the controller which function is needed
	public void beforeMsg()
	{
		log.info("BikeViewPage() is going to be invoked");	
	}
	
	@After("execution (public String com.example.bikeshowroom.controller.BikeController.bikeViewPage(..))")
	public void afterMsg()
	{
		log.info("BikeViewPage() invoked successfully ");
	}

}
