package com.revature;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RestAssuredLauncher {
	 public static void main(String[] args){
	        new SpringApplicationBuilder() //
	        .sources(RestAssuredLauncher.class)//
	        .run(args);
	  }

}
