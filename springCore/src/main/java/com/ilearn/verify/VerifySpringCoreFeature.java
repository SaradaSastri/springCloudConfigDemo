package com.ilearn.verify;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ilearn.beans.DemoManager;
import com.ilearn.config.ApplicationConfiguration;
import com.ilearn.restTemplate.RestTemplateDemo2;

public class VerifySpringCoreFeature 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	    DemoManager  obj = (DemoManager) context.getBean("demoService");
	    System.out.println( obj.getServiceName());
	    RestTemplateDemo2.getProperty();
	}
}
