package com.ticketbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ticketbooking.service.TicketService;

@SpringBootApplication
public class TicketBookingApplication implements CommandLineRunner{
	
	@SuppressWarnings("unused")
	@Autowired
	private TicketService ticketService;	//dummy ticket
	
	//CommandLineRunner ==> We should implement run method and run method will be called only during project startup
	//run() method will be called only once by the framework.We no need to call explicitly.
	public static void main(String[] args) {
		SpringApplication.run(TicketBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		Ticket ticketObj=new Ticket();
		ticketObj.setPassengerName("Raju");
		ticketObj.setSourceStation("Delhi");
		ticketObj.setDestinationStation("Mumbai");
		ticketObj.setTravelDate(new Date());
		ticketObj.setEmail("raju@gmail.com");
		
		ticketService.createTicket(ticketObj);
			*/
	}
}
