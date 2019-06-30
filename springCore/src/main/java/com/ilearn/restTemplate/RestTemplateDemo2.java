package com.ilearn.restTemplate;

import java.util.Properties;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateDemo2 {

	public static Properties getProperty() {
		Properties prop = new Properties();
		RestTemplate restTemplate = new RestTemplate();
		//String propResourceUrl  = "http://localhost:8888/config-client/development";
		String propResourceUrl  = "http://localhost:8888/config-client-development.properties";
		/*
		ResponseEntity<PropertiesPojo> response = restTemplate.getForEntity(propResourceUrl, PropertiesPojo.class);
		System.out.println(response);
		//assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));*/
		
		ResponseEntity<String> response = restTemplate.getForEntity(propResourceUrl, String.class);
		String body = response.getBody();
		
		String[] property = body.split("\n");
		for(String obj : property) {
			String[] key = obj.split(":");
			prop.put(key[0].trim(), key[1].trim());					
		}
		System.out.println("Properties constructed from config-server-->"+prop );
		return prop;
	}
}
