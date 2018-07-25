package com.example.capgemini.jst.SpringCapmates;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
	private static final Logger LOGGER= LoggerFactory.getLogger(TestAspect.class);
	
	@Before("execution(* com.capgemini.jst.repositories.HistoryDao.*.*(..))")
	public void beforeAnyMethodInService() {
	LOGGER.info ("testetestettetestttetetetetestttttttteeeeeeeeeeeest");
	}
}
//gwiazdka - wszystkie typy, pozniej paczka, tez moze byc gwiazdka, pozniej klasa, metoda i argumenty, 
//tez moga byc gwiazdki