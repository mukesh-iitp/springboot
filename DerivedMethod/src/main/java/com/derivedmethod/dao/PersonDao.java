package com.derivedmethod.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.derivedmethod.model.Person;

@Repository
public interface PersonDao extends CrudRepository<Person, Integer>{
	
	/*
	 * 
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
	
	 
	//Name Query Section
	//Abstract Method at Interface Layer and Implementation at POJO or Domain Class Level
	
	public List<Person> giveDataByName(String firstName);	//Abstract Method (Any method name) 
	
	public List<Person> giveFewColumns(String firstName); 	//Abstract method for getting few columns
	
}
