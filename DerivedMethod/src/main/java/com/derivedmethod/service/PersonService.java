package com.derivedmethod.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derivedmethod.dao.PersonDao;
import com.derivedmethod.model.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao; //PersonDao personDao=ioc.getPersonDao();
	
	public Iterable<Person> saveAllPersons(Iterable<Person> personList){
		return personDao.saveAll(personList);
	}
	
	public Iterable<Person> getPersonsData(Iterable<Integer> personIds){
		return personDao.findAllById(personIds);
	}
	
	public List<Person> findByFirstName(String firstName){
		return personDao.findByFirstName(firstName);
	}
	
	public Person findByLastNameAndFirstName(String lastName,String firstName){
		return personDao.findByLastNameAndFirstName(lastName, firstName);
	}
	
	public List<Person> findByLastNameOrFirstName(String lastName, String firstName){
		return personDao.findByLastNameOrFirstName(lastName, firstName);
	}
	
	public List<Person> findByLastNameOrderByCreatedDateDesc(String lastName){
		return personDao.findByLastNameOrderByCreatedDateDesc(lastName);
	}
	
	public List<Person> findByAgeLessThanEqual(Integer age){
		return personDao.findByAgeLessThanEqual(age);
	}
	
	public List<Person> findByFirstNameLike(String firstName){
		return personDao.findByFirstNameLike(firstName);
  	}
	
	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName, int age){
		return personDao.findByLastNameAndAgeLessThanEqual(lastName, age);
	}
	
	public List<Person> findByCreatedDateBetween(Date startDate, Date endDate){
		return personDao.findByCreatedDateBetween(startDate, endDate);
	}
	
	//Calling of Named Query
	public List<Person> giveDataByName(String firstName){
		return personDao.giveDataByName(firstName);
	}
	
}
