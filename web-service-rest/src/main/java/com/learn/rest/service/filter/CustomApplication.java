package com.learn.rest.service.filter;

import org.glassfish.jersey.server.ResourceConfig;

public class CustomApplication extends ResourceConfig{

	
	public CustomApplication() {
		packages("com.learn.rest");
 
        //Register Auth Filter here
        register(SecurityFilter.class);
	}
}
