package com.webservice.soap.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.webservice.soap.exception.ProductException;
import com.webservice.soap.model.Product;

@WebService(name="productCatlogTest",targetNamespace="http://test.com.webservice")
public interface ProductCatlog {
	
	@WebMethod(action="fetchProdAction",operationName="fetchProdOp")
	@WebResult(partName="prodsResult",name="products")
	public List<Product> getProducts() throws ProductException ;
	
	@WebMethod(action="addProdAction",operationName="addProdOp",exclude=false)
	public void addProducts(@WebParam(name="prodInput") Product product,@WebParam(name="prodStatus") String prodstatus) throws ProductException ;
	

}
