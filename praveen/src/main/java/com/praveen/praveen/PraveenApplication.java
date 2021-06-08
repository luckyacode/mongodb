package com.praveen.praveen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling

public class PraveenApplication{
	@Value("${welcome.txt}")
	String txt;
	
	public static void main(String[] args) {
	SpringApplication.run(PraveenApplication.class, args);	
	}
	
	@RequestMapping(value="/")
	public String txt(){
		return txt;
	}
	
}
//Zuul Server is a gateway application that handles all the requests and 
//does the dynamic routing of microservice applications. The Zuul Server 
//is also known as Edge Server.
//For Example, /api/user is mapped to the user service and /api/products 
//is mapped to the product service and Zuul Server dynamically routes 
//the requests to the respective backend application.
//zuul server auto proxy router auto
//path in application.properties
//spring.application.name = zuulserver
//zuul.routes.products.path = /api/demo/**
//zuul.routes.products.url = http://localhost:8080/
//server.port = 8111



//	@Bean
//	public RestTemplate getRestTemplate(){
//		return new RestTemplate();
//	}
//}




//public class PraveenApplication extends SpringBootServletInitializer {
//	private static final Logger log = LoggerFactory.getLogger(PraveenApplication.class);
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
//		return application.sources(PraveenApplication.class);
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(PraveenApplication.class, args);
//		log.info("after run main");
//		System.out.println("OK HELLO");
//	}
//	@RequestMapping(value="/")
//	public String hello(){
//		log.info("ok now");
//		return "Hi praveen tripathi";
//	}
//
//}
