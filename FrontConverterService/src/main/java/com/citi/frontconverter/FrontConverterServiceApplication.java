package com.citi.frontconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan({"com.citi.frontconverter.controller"})
public class FrontConverterServiceApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(FrontConverterServiceApplication.class, args);
		
		//Convert convert = context.getBean("convert", Convert.class);
	}

	
	  @Bean
	    public RestTemplate restTemplate(){
	        return new RestTemplate();
	    }
}
