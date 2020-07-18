package com.magic.camel.example5;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class FileToActiveMQ {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		ConnectionFactory cf = new ActiveMQConnectionFactory();
		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(cf));
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("file:input_box?noop=true").
				to("activemq:queue:camel_example");
			}
		});
		context.start();
		while(true);
		
	}

}
