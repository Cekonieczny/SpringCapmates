package com.example.capgemini.jst.SpringCapmates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy 
@SpringBootApplication
public class SpringCapmatesApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringCapmatesApplication.class, args);
	}
}
