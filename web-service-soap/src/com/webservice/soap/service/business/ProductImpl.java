package com.webservice.soap.service.business;

import java.util.ArrayList;
import java.util.List;

import com.webservice.soap.model.Product;

public class ProductImpl {
	List<Product> products = new ArrayList<>();
	
	public List<Product> getProducts(){
		return products;
	}
	
	public List<Product> addProducts(Product product){
		products.add(product);
		return products;
	}

}
