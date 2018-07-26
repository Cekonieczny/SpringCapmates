package com.capgemini.jst.SpringCapmates;

import java.time.LocalTime;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HistoryDaoAspect {
	private LocalTime before;
	private LocalTime after;
	private int difference;
	private static final Logger LOGGER= LoggerFactory.getLogger(HistoryDaoAspect.class);
	
	@Before("execution(* com.capgemini.jst.SpringCapmates.repositories.HistoryDao.*(..))")
	public void beforeAnyMethodInDao() { before = LocalTime.now();
	LOGGER.info ("logging time before method was executed");
	}
	
	@After("execution(* com.capgemini.jst.SpringCapmates.repositories.HistoryDao.*(..))")
	public void afterAnyMethodInDao() { after = LocalTime.now();
	difference = (after.getNano()-before.getNano())/1000000;
	LOGGER.info ("execution time of the method: "+difference+ " miliseconds");
	}
}
//gwiazdka - wszystkie typy, pozniej paczka, tez moze byc gwiazdka, pozniej klasa, metoda i argumenty, 
//tez moga byc gwiazdki