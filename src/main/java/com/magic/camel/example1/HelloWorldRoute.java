package com.magic.camel.example1;

import org.apache.camel.builder.RouteBuilder;

public class HelloWorldRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		System.out.println("Hello world!");
	}

}
