package com.ilearn.restTemplate;

import org.springframework.web.client.RestTemplate;

public class RestTemplateDemo {

	public static void getProperty() {
		RestTemplate restTemplate = new RestTemplate();
		String propResourceUrl  = "http://localhost:8888/config-client/development";
		/*
		ResponseEntity<PropertiesPojo> response = restTemplate.getForEntity(propResourceUrl, PropertiesPojo.class);
		System.out.println(response);
		//assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));*/
		
		PropertiesPojo propertiesPojo = restTemplate.getForObject(propResourceUrl, PropertiesPojo.class);
		System.out.println(propertiesPojo.getName());
		System.out.println("prop=" + propertiesPojo.getAllProperties());
		System.out.println("prop=" + propertiesPojo.getAllProperties().getProperty("password"));
		
	}

}
