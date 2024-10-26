package com.NamedQuery.dao;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.NamedQuery.model.CustomType;
import com.NamedQuery.model.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer>{
	
	/*
	 * We are going to implement saveAll and findAllById method.
	 * Methods are already defined in JPA and is implemented in Service layer.
	 */

	//Derived Methods ==> writing Abstract Methods at Interface Layer and JPA Framework will implement
	
	//Input and Output which data structure we need to use is of Developer Choice
	public List<Person> findByFirstName(String firstName);
	//Query -> select * from tbl_person where first_name=firstName;
	
	//G.Vijay -> G:Surname Lastname ==> Vijay ==>firstName
	public Person findByLastNameAndFirstName(String lastName,String firstName);
	//Query -> select * from tbl_person where last_name=lastName and first_name=firstName
	
	public List<Person> findByLastNameOrFirstName(String lastName, String firstName);
	//Query -> select * from tbl_person where last_name=lastName or first_name=firstName
	
	public List<Person> findByLastNameOrderByCreatedDateDesc(String lastName);
	//Query -> select * from tbl_person where last_name=lastName Order by created_date desc;
	
	public List<Person> findByAgeLessThanEqual(Integer age);
	//Query -> select * from tbl_person where age<=age
	
	public List<Person> findByFirstNameLike(String firstName);
	//Like Keyword for wildCard Search and developer need to populate "%" symbol manually
	//Query -> select * from tbl_person where first_name like '%firstName%'

	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName, int age);
	//Query => select * from tbl_person where last_name=lastName and age<=age;
	
	public List<Person> findByCreatedDateBetween(Date startDate, Date endDate);
	//Query => select * from tbl_person where create_date=startDate and created_date==endDate;
	
	public List<Person> giveDataByName(String firstName);	//Abstract Method (Any method name) 

	public List<CustomType> giveFewColumns(String firstName);	//Abstract Method for getting few columns
	
	//Query -> We are going to write JPQL -> Writing Java Classes and Java properties
	@Query(value="SELECT p FROM Person p where p.firstName=?1 OR p.email=?2") //Implementation
	List<Person> findPersonInfobyFirstNameorEmail(String firstName,String email); //Abstract Method

	//NativeQuery -> We are going to write SQL -> Writing database tables and database columns
	@Query(value="SELECT * FROM tbl_person p where p.first_name=?1",nativeQuery = true)
	List<Person> findPersonINfobyFirstname(String firstName);
	
	//Pagination Section
	public List<Person> findByLastName(String lastName, Pageable pagable);	//Abstract method
	
	public List<Person> findByEmail(String email);	//Synchronous method
	
	@Async
	public CompletableFuture<Person> findByemail(String email);	//Asynchronous method
	//We have separate data type CompletableFuture, it indicated in a future reference.
	//It is going to give immediately once complete. 
	
}
