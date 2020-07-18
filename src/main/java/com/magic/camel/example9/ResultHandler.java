package com.magic.camel.example9;

import java.util.List;

public class ResultHandler {
	
	public void printResult(List<?> list) {
		
		for (Object object : list) {
			System.out.println(object);
		}
	}

}
