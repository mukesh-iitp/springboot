package com.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.dao.TicketDao;
import com.ticketbooking.model.Ticket;

/*
 * Business Logic -> Service Layer and also Transaction Management
 * 
 * 
 */


@Service
public class TicketService {
	
	@Autowired
	//This spring annotation automatically wire it because already TieketDAO is ther in IOC container.
	//Please take care of this IOC container TicketDAO and use that reference and keep the data.
	private TicketDao ticketDao; //internally written as: TicketDAO ticketDao=new TicketDao();
	
	//Create Ticket
	public Ticket createTicket(Ticket ticketObj) {
		return ticketDao.save(ticketObj);
		//Save method is for inserting and updating.	
		
		/*
		 * If Ticketobj.ticketID -> null (no value) -> insert
		 * 	  Ticketobj.ticketID -> Some value=> Not there in the database --> INSERT
		 * 	  
		 * 	  Ticketojb.ticketID -> Some value=? Exists in the database -> UPDATE
		 * 
		 */
	}
	
	//Retrieve All Tickets
	public Iterable<Ticket> getAllTikets(){
		return ticketDao.findAll();
		//findAll -> select * from tbl_ticket
	}
	
	
	//Retrieve Specific Ticket
	public Ticket retrieveTicket(Integer ticketId) {
		return ticketDao.findById(ticketId).orElse(new Ticket());
		//findByID -> select * from tbl_ticket where ticket_id=ticketId
		
	}
	
	
	//Delete Ticket
	public void deleteTicket(Integer ticketId) {
		ticketDao.deleteById(ticketId);
		//deleteByID -> delete from tbl_ticket where ticket_id=ticketId
	}
	
	//Update Ticket
	public Ticket updateTicket(Integer ticketId,String newEmail) {
		Ticket dbTicketObj=retrieveTicket(ticketId);
		dbTicketObj.setEmail(newEmail);
		return ticketDao.save(dbTicketObj);
		//Here save method will update since dbTicketObj.ticketId===exists in the database
		
	}

}
