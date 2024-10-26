package com.STSHelloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

/* 
 * WebServices => Heterogeneous communications is called as WebServices.
 * 					Two different programming languages can communicate with each other. 
 * 	In our scenarios typescript, javascript, node JS etc which can be interacted with Java.
 * 
 * Two types of WebServices ===>
 * 	1) SOAP Services --> SOAP Services have limitation of protocol, stub, proxy, Data Exchange and Binding etc.,
 * 	2) REST Services --> This service works on Http Protocol and does not require any extra binding methodologies.
 * 
 * We can expose any of our business service to the Internet ==>
 * 			so that any programming language or any other external business application consume this service.
 * 
 * Spring Application uses the REST services for exposing the business functionality.And they have created REST Controller on top of controller.
 * 
 * In Spring MVC(Model View Controller) ==> It is the Spring MVC where controller is communicating between model and view.
 * Spring MVC internally creates --> Dispatcher Servlet --> It will have View to Model Mapping.
 *	e.g. product.jsp ==> Get Button clicked ==> Dispatcher Servlet redirectes to ProductConroller.getProduction() ==> It will make a database call and gets the data.
 * 
 * Using Spring MVC, the same architecture is leveraged and RESTController is introduced where view can be any external system and can communicate with RESTController which internally interact with models.
 * In other words -> RESTController means = Rest Protocol + @Controller.
 * 
 * How View, Controller and Model are interacting with each other.
 * 	View => Angular, React, Node, Go, Vue, Spring MVC 
 * 	Controller => Spring Boot Application
 * 	Model => Database
 * 	
 * 	Both Controller and view uses a common data access object ==> JSON/XML
 * 	JSON/XML data access object is understandable to each and every programming language.
 * 	What happens here, whenever click a button on Angular client, the information is conveyed in JSON format, Rest protocol takes the JSON format and it conveys the message to springboot application.
 * 	As getProduct button is clicked i.e. making a call to springboot to get the data. Now @RESTController will have the dispatcher servlet, it will go to product controller and gets the product.
 * 	Then list/set product is returned by springboot application in java data structure. rest protocol will convert the data in JSON format and passed to Angular Client.
 *	
 *	XML data access object can also be used, but developer need to take care of converting XML to Java or Java to XML by writing a programming code.
 *	
 *	But Java to JSON and JSON to Java conversion will be tanke care internally by the Spring Boot application only. Developer no need to write any boiler plate code in these conversions.
 *
 * 	JSON ==> Javascript Object with a structure as below
 * 				{
 * 						Key: vlaue
 * 						name: "vijaykumar"
 * 						city: "Hyderabad"
 * 				}
 * 
 * 
 * 
 */

public class HelloWorldImpl {
	
	
	@RequestMapping(value = "/")
	public String getHelloWorld() {
		return "Welcome to Spring Boot Hello World using STS approach";
	}

}
