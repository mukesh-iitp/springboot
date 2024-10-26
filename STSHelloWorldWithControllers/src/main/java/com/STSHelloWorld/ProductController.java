package com.STSHelloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/products")	//http://localhost:8080/products
//  http://localhost:8080/products ===> ProductController obj=ioc.getProductController();
//During Application startup, DispatcherServlet will register all rest controllers to IOC container
//So that on Invoking specific URL, Respective Controller will be instantiated.
public class ProductController {
	
	//Create Product
	//Retrieve Product
	//Update Inventory
	//Delete Product
	
	
	//Retrieval Part
	
	//http://localhost:8080/products/all
	@RequestMapping(value="/all")	//obj.getProducts();
	public String getProducts() {
		return "Product List....TV, Washing Machine....";
	}
	
	
	//Retrieve specific product
	
	@RequestMapping(value="/one") //http://localhost:8080/products/one
	//http://localhost:8080/products/one ==>obj.getProduct();
	public String getProduct() {
		return "TV...One Prodcut";
	}
	
	@RequestMapping(value="/other") //http://localhost:8080/products/other
	//http://localhost:8080/products/other ==>obj.getWashingMachine();
	public String getWashingMachine() {
		return "Washing Machine";
	}
	
	

}
