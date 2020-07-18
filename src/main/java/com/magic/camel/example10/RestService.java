package com.magic.camel.example10;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class RestService {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				restConfiguration().component("restlet").host("localhost").port(8080);
				rest("/api/users").get().route().setBody(constant("Yash,Gandhi,Hello"));
			}
		});
		context.start();

	}

}
