package com.ilearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ilearn.beans.DemoManager;
import com.ilearn.beans.DemoManagerImpl;

@Configuration
public class ApplicationConfiguration {
	
	@Bean(name="demoService")
    public DemoManager helloWorld() {
        return new DemoManagerImpl();
    }

}
