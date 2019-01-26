package com.microservices.service.resource;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.service.model.Users;

@RestController
@RequestMapping("/rest/service")
public class ServiceController {
	
	
	@Autowired
    RestTemplate restTemplate;
	

	
	
	 @GetMapping("/{username}")
	    public  ResponseEntity<Users[]> getStock(@PathVariable("username") final String userName) {
		 
	    	
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
	    	HttpEntity<String> request = new HttpEntity<String>( headers);
		
		 
		 ResponseEntity<Users[]> response = restTemplate.exchange("http://db-service/rest/db/" + userName, HttpMethod.GET,
				 request,Users[].class );
		 /*
		 String body = entity.getBody();
		 org.springframework.http.MediaType contentType = entity.getHeaders().getContentType();
		 HttpStatus statusCode = entity.getStatusCode();
		 
	     return body;*/
		 
		 return  response;
		
		 
	 }
}
