package com.anchal.sakhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SakhiApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext=SpringApplication.run(SakhiApplication.class, args);
	}

}
