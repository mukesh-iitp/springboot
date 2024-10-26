package com.NamedQuery.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NamedQuery.dao.BookDao;
import com.NamedQuery.dao.EmployeeDao;
import com.NamedQuery.dao.PersonDao;
import com.NamedQuery.model.Book;
import com.NamedQuery.model.CustomType;
import com.NamedQuery.model.Employee;
import com.NamedQuery.model.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao; //PersonDao personDao=ioc.getPersonDao();
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private EmployeeDao empDao;
	
	public List<Person> findPersonInfobyFirstNameorEmail(String firstName,String email){
		return personDao.findPersonInfobyFirstNameorEmail(firstName, email);
	}
	
	public List<Person> findPersonINfobyFirstname(String firstName){
		return personDao.findPersonINfobyFirstname(firstName);
	}
	
	
	public List<CustomType> giveFewColumns(String firstName){
		return personDao.giveFewColumns(firstName);
	}
	
	public List<Object[]> findMaxSalariesByDept(List<String> deptNames){
		return empDao.findMaxSalariesByDept(deptNames);
	}
	
	public Iterable<Employee> saveAllEmployees(Iterable<Employee> empList){
		return empDao.saveAll(empList);
	}
	
	public Iterable<Employee> findAllEmployees(){
		return empDao.findAll();
	}
	
	
	public Iterable<Book> saveAllBooks(Iterable<Book> booksData){
		return bookDao.saveAll(booksData);
		
	}
	
	public Iterable<Book> getAllBooks(){
		return bookDao.findAll();
	}
	
	public Iterable<Book> listBooksWithName(String bookName){
		return bookDao.listBooksWithName(bookName);
	}
	
	//Calling of Named Query
	public List<Person> giveDataByName(String firstName){
		return personDao.giveDataByName(firstName);
	}
	
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
	
}
