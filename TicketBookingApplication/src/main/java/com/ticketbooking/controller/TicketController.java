package com.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.model.Ticket;
import com.ticketbooking.service.TicketService;

@RestController
@RequestMapping(value="/tickets") //http://localhost:8080/tickets
//http://localhost:8080/tickets => TicketController ticketObj=ioc.getTicketController();
//Dependency injection with IOC, framework is going to give and object. 
//Whenever we provide the url-http://localhost:8080/tickets, ticket controller will be instantiated
public class TicketController {
	
	/*
	 * Rest Services are part of WebService.
	 * 
	 * WebService => Heterogeneous communication -> Different programming languages want to communicate each other.
	 * 
	 * In Java, WebServices are of tow types => 1) SOAP	 and  2) REST
	 * 
	 * In SOAP base services, we have complexicity in data format, protocol, contract, proxy, stub
	 * 
	 * REST Based Service -> It uses normal HTTP Protocol and normal HTTP method like GET, POST, PUT, DELETE will suffice
	 * 
	 * @RestController -> @Rest Protocol + @Controller (Spring Controller)  == we can get request from anywhere like, angular/react etc.
	 * 
	 * What is the difference between @Controller and @RestController?
	 * @Conroller, we are going to get request from particular jsp, html inside the application only. Thus @controller is used within the application only
	 * @RestController, we can access our end point or methods from anywhere
	 * 
	 * In @RestController sprinboot comes with new annotations:
	 * 
	 * 		Get -> @Get + @RequestMapping -> @GetMapping
	 * 		Create -> @Post + @RequestMapping -> @PostMapping
	 * 		Update -> @Put + @RequestMapping -> @PutMapping
	 * 		Delete -> @Delete + @RequestMapping -> @DeletMapping
	 * 
	 * By default Rest Services uses JSON Object as communication
	 * JSON -> JavaScript Object Notation ->{
	 * 											key1:value1,
	 * 											key2:value2,
	 * 											key3:value3
	 * 											address:[
	 * 														tempaddress:{
	 * 																	 key1:value1
	 * 																	}
	 * 														permaddress:{
	 * 																	 key1:value1
	 * 																	}
	 * 													]
	 * 										 }
	 * Developer no need to write code in converting java object to JSON and JSON object to Java
	 * It internally uses JACSON Library for converting JSON to Java and JAVA to JSON
	 * 
	 */
	
	@Autowired
	private TicketService ticketService;
	//GetAllTikets
	@GetMapping(value="/all") //http://localhost:8080/all ->ticketObj.getAllTickets();
	public Iterable<Ticket> getAllTickets(){
		return ticketService.getAllTikets();	
	}
		
	//Retrieving single ticket
	//http://localhost:8080/tickets/1 => 1st Ticket
	//http://localhost:8080/tickets/100 => 100st Ticket	
	//{} ==> Dynamic Variable
	//@PathVariable -> Annotation which is reading the value from URL
	@GetMapping(value="/{ticketId}")
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
		return ticketService.retrieveTicket(ticketId);
	}
	
	//Delete Ticket
	@DeleteMapping(value="/{ticketId}")
	//http://localhost:8080/tickets/1 ->1st ticket
	//http://localhost:8080/tickets/100 ->100st ticket
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
			ticketService.deleteTicket(ticketId);
	}
	//Here, URL of getTicket & deleteTicket are same.
	//URL uniqueness is maintained as  URL + request type/verb
	
	
	//Create Ticket
	@PostMapping(value="/create")
	//http://localhost:8080/tickets/create
	//@PostMapping will throw an error if the data/resource already exists in the database.
	//@RequestBodby ==> Entire Ticket.json exists in body
	public Ticket createTicket(@RequestBody Ticket ticketObj) {
		return ticketService.createTicket(ticketObj);
	}
	
	//Update Ticket
	//http://localhost:8080/tickets/1/vijay@yahoo.com -> 1st Ticket
	//http://localhost:8080/tickets/100/ramu@yahoo.com -> 100st Ticket
	@PutMapping(value="/{ticketId}/{newEmail}")
	//@PutMapping, if the data/resource already exists in the database, it will update and resource not there, it will create.
	public Ticket updateTicket(
			@PathVariable("ticketId") Integer ticketId,
			@PathVariable("newEmail") String newEmail){
		return ticketService.updateTicket(ticketId, newEmail);
	}
	

}
