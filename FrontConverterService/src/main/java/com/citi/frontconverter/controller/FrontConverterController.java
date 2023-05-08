package com.citi.frontconverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/converter")
public class FrontConverterController {
	
	@Autowired
	private RestTemplate restTmp ;
	
	

	double convertedresult;
	double doubleValue;
	String formula;
	
	@GetMapping("/{fromUnit}/{toUnit}/{value}")
	public  ResponseEntity<Double> getUnitValue(@PathVariable String fromUnit,
			@PathVariable String toUnit, @PathVariable double value) {
		
		String convertedUnit = fromUnit+"-"+toUnit;
		
		try {
	
	 formula = restTmp.getForObject("http://localhost:8080/getConvertedUnit/convertedUnit", String.class);
	
		}catch(Exception e) {
			System.out.println("exception at the time of crud microservice callng"+e);
		}
	if(formula.charAt(0)=='*') {
		
		formula = formula.replace("*", "");
		 doubleValue = Double.parseDouble(formula);
		 convertedresult = value*doubleValue;
		
	}
	else 
	{
		formula = formula.replace("/", "");
		 doubleValue = Double.parseDouble(formula);
		 convertedresult = value/doubleValue;
	}
	
		
	
	return  ResponseEntity.ok(convertedresult);
		
		
	
	}
	

}
