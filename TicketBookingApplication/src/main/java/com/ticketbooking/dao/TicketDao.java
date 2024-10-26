package com.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooking.model.Ticket;


/*
 * DAO => Data Access Object. This object is wrapper on the top of database
 * For communicating with database we use DAO.
 * 
 * We need to connect to database and DriverManager.getConenction, connection.open... and
 * we need to use insert statement, update, execute update........PreparedStatement -> 
 * All these are automated by spring boot with @Repository annotation.
 * 
 * Spring boot comes with CRUPRepository concept. Developer no need to create method for db query.
 * CRUDRepository -> C=CREATE (INSERT) R= READ U=UPDATE D=DELETE
 * 				  -> It has two Input Parameters -> 1. Java Class Name (which is table name)
 * 													2. Data type of Primary Key
 * 
 */

@Repository
public interface TicketDao extends CrudRepository<Ticket, Integer>{
	
	/*
	 * TicketDAO will have 3 methods
	 * 
	 * 1. save -> Insert and Update -> TicketDao.save() -> insert into or update
	 * 2. Retrieve All -> TicketDao.findAll() -> select * from ticket
	 * 3. Retrieve Specific Record -> TicketDao.findByID() -> select * from ticket where ticket_id=?
	 * 4. Delete -> TicketDAO.deleteByID() -> delete from ticket where ticket_id=?
	 * 
	 * we no need to write these methods codes. All these methods are written by the framework which support CRUD operations
	 * just we need to tag our ticket object to TicketDAO using CRUDRepository 
	 * 
	 */	
	

}
