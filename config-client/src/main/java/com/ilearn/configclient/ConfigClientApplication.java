package com.ilearn.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
	
	//The value of the property username is directly injected on bootstrap from config server
	@Value("${username}")
    private String username;
 
    @RequestMapping(
      value = "/whoami/{properName}", 
      method = RequestMethod.GET, 
      produces = MediaType.TEXT_PLAIN_VALUE)
    public String whoami(@PathVariable("properName") String properName) {
        return String.format("Hello! You're %s and you'll become a(n) %s...\n", properName, username);
    }

}
