package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class MsfJmsWithDistnationConsumerApplication {

	@Autowired
	JmsTemplate jmsTemplate; 
	
	public static void main(String[] args) {
		SpringApplication.run(MsfJmsWithDistnationConsumerApplication.class, args);
	}
	
	@JmsListener(destination="order-queue")
	private void getMessage(String msg) {
		this.jmsTemplate.convertAndSend("order-queue-response", "message from backeend is:"+msg);
		System.out.println("message send back");
	}
}
