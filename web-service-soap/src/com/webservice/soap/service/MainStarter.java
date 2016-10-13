package com.webservice.soap.service;

import javax.xml.ws.Endpoint;

public class MainStarter {

	

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:1234/service", new ProductCatlogServiceImpl());
		

	}

}
