package com.webservice.soap.service;

import java.util.List;

import javax.jws.WebService;

import com.webservice.soap.exception.ProductException;
import com.webservice.soap.model.Product;
import com.webservice.soap.service.business.ProductImpl;

@WebService(endpointInterface="com.webservice.soap.service.ProductCatlog",serviceName="ProdService",portName="prodPort"
)
public class ProductCatlogServiceImpl implements ProductCatlog {
	ProductImpl impl = new ProductImpl();

	@Override
	
	public List<Product> getProducts() throws ProductException{
		List<Product> prods = impl.getProducts();
		
		if(null == prods || prods.isEmpty())
			throw new ProductException("Prod is empty", "prod is empty");
		return prods;
	}

	@Override
	public void addProducts( Product product,String productStatus) throws ProductException {
		impl.addProducts(product);
		
	}
}
