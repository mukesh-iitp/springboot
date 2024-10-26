package com.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
 * Bootstrap Class -> @SpringBootApplication
 * Boot is nothing but booting, staring point. And strap is wrapping.
 * Whenever we run our project, the first file loaded is a Bootstrap class.
 * Bootstrap class is an entry point of execution.  
 * 
 * Every Spring Project should contain only one bootstrap class.
 * What exactly does:-
 * It will create an IOC Container(Inversion of Control)
 * with Dependency Injection Principle it will manages the garbage collection process efficiently.
 *
 * 1000 java files => Moved to IOC Container
 * 
 * PaymentService.java => processPayment
 * 		Legacy Approach => PaymentService obj=new PaymentService();
 * 						=> obj.porcessPayment();
 * 		In SpringBoot Approach => PaymentService obj=ioc.getPaymentService();
 * 
 * It will push all the java files to IOC container which are identified as part of web application context.
 * 
 * 
 * 
 */
public class HelloWorldApplication 
{	
	 public static void main(String[] args) 
	 {
		 /*
		  * We need to create web application context.
		  * Web Application context will create a temporary area where all our class will reside.
		  * Context is nothing but all the codes will be available in on container that is web application context.
		  * So that it will be easy to search.
		 
		  * In Spring we will write the following code to create web application context.
		  * 
		  * <bean id="com.helloworld.HelloWorldApplction" name="obj">
		  * 
		  * ApplicationContext context=new XmlApplictoinContext(...xml);
		  * 
		  * SpringApplication.run -> It will create Web ApplicationContext.
		  * By default, it will scan all the java files which are created under HelloWorldApplication.java package and its sub packages, and then moved to the IOC container
		  * 
		  *  	com.amazon.order.processing	->com.amazon.order.processing.inventory
		  *  								->com.amazon.order.processing.customer
		  *  								->com.amazon.order.processing.catlog
		  *  								->com.amazon.order.processing.stock
		  *  								->com.amazon.order.processing.discount
		  *  								->com.amazon.order.processing.cart
		  *  								->com.amazon.order.processing.payment
		  *  								->com.amazon.order.processing.shipping
		  *  								->com.amazon.order.processing.return
		  *  	Main Package -> com.amazon.order.processing
		  *  	Sub packages -> com.amazon.order.processing.*;
		  *  
		  *  Also, SpringBoot will create dispatcher servlet.
		  *  
		  */
		 
		 SpringApplication.run(HelloWorldApplication.class, args);
		 
	 }
}
