package com.revature.gambit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@SpringBootConfiguration
//@EnableSwagger2
@EnableEurekaClient
public class application {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(application.class, args);
	}

//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.revature.gambit")).paths(PathSelectors.any()).build();
//	}

}
