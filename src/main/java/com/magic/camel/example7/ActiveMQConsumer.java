package com.magic.camel.example7;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class ActiveMQConsumer {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		ConnectionFactory cf = new ActiveMQConnectionFactory();
		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(cf));
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("activemq:queue:camel_example").
				to("seda:end");
			}
		});
		
		context.start();
		ConsumerTemplate consumer = context.createConsumerTemplate();
		while(true) {
			String message = consumer.receiveBody("seda:end", String.class);
			System.out.println(message);
		}
		
	}

}
