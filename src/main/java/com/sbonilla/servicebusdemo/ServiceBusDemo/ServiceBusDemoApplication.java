package com.sbonilla.servicebusdemo.ServiceBusDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class ServiceBusDemoApplication {
	// JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ServiceBusDemoApplication.class, args);
	}

}
