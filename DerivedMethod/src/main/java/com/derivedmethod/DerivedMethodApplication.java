package com.derivedmethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.derivedmethod.model.Person;
import com.derivedmethod.service.PersonService;

@SpringBootApplication
public class DerivedMethodApplication implements CommandLineRunner{

	@Autowired
	private PersonService personService;
	
	public static void main(String[] args) {
		SpringApplication.run(DerivedMethodApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//saveAll
		
		//findAllById
		
		//createPersons();
		
		//getPersons();
		
		//findByFrstName();
		//findByFirstNameAndLastName();
		//findByFirstNameOrLastName();
		//findByLastNameOrderByCreateDateDesc();
		//findByAgeLessThanEqual();
		//findByFirstNameLike();
		//findByLastNameAndAgeLessThanEqual();
		//findByCreatedDateBetween();
		
		giveDataByName();
		
		
	}
	
	
	private void findByFrstName() {
		Iterable<Person> personList =personService.findByFirstName("Ram");
		for(Person person:personList) {
			System.out.println("Person Object"+person.toString());
		}
	}
	
	private void findByFirstNameAndLastName() {
		Person person=personService.findByLastNameAndFirstName("kumar", "ram");
		System.out.println("Person Object"+person.toString());
	}
	
	private void findByFirstNameOrLastName() {
		Iterable<Person> personList=personService.findByLastNameOrFirstName("kumar", "ram");
		for(Person person:personList) {
			System.out.println("Person Object"+person.toString());
		}
	}
	
	private void findByLastNameOrderByCreateDateDesc() {
		Iterable<Person> personList = personService.findByLastNameOrderByCreatedDateDesc("kumar");
		for(Person person:personList) {
			System.out.println("Person Object"+person.toString());
		}
	}
	
	private void findByAgeLessThanEqual() {
		Iterable<Person> personList=personService.findByAgeLessThanEqual(20);
		for(Person person:personList) {
			System.out.println("Person Object"+person.toString());
		}
	}
	
	private void findByFirstNameLike() {
		Iterable<Person> personList=personService.findByFirstNameLike("%Kiran%");
		for(Person person:personList) {
			System.out.println("Person Object"+person.toString());
		}
		
	}
	
	
	private void findByLastNameAndAgeLessThanEqual() {
		Iterable<Person> personList=personService.findByLastNameAndAgeLessThanEqual("Kumar", 40);
		for(Person person:personList) {
			System.out.println("Person Object"+person.toString());
		}
		
	}
	
	private void findByCreatedDateBetween() {
		//2022-09-07 01:01:47
		Iterable<Person> personList=personService.findByCreatedDateBetween(
				getDatewithTime("2022-09-07 01:01:46"),
				getDatewithTime("2022-09-07 01:01:50"));
		for(Person person:personList) {
			System.out.println("Person Object"+person.toString());
		}
		
	}
		
	
	private Date getDatewithTime(String dateString) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return format.parse(dateString);
		}
		catch(ParseException pe) {
			throw new RuntimeException(pe);
		}
	}
	
	
	

	private void createPersons() {
		
		/*
		List<Person> personList=new ArrayList<Person>();
		
		personList.add(new Person("Kiran","Kumar","Kiran@gmail.com",20));
		
		personList.add(new Person("Kiran","Kumar","Kiran@gmail.com",20));
		personList.add(new Person("Kiran","Kumar","Kiran@gmail.com",20));
		personList.add(new Person("Kiran","Kumar","Kiran@gmail.com",20));
		personList.add(new Person("Kiran","Kumar","Kiran@gmail.com",20));
		personList.add(new Person("Kiran","Kumar","Kiran@gmail.com",20));
		personList.add(new Person("Kiran","Kumar","Kiran@gmail.com",20));
		personList.add(new Person("Kiran","Kumar","Kiran@gmail.com",20));
		personList.add(new Person("Kiran","Kumar","Kiran@gmail.com",20));
		personList.add(new Person("Kiran","Kumar","Kiran@gmail.com",20));
		
		*/
		
		//List<Person> personList=new ArrayList<Person>();
		//Person per=new Person();

		List<Person> personList = Arrays.asList(
				new Person("Kiran", "kumar", "kiran@gmail.com", 20),
				new Person("Ram", "kumar", "ram@gmail.com", 22),
				new Person("RamKiran", "LaxmiKiran", "sita@gmail.com", 30),
				new Person("Lakshamn", "Seth", "seth@gmail.com", 50),
				new Person("Sita", "Kumar", "lakshman@gmail.com", 50),
				new Person("Ganesh", "Kumar", "ganesh@gmail.com", 50),
				new Person("KiranKiran", "kumar", "kiran@yahoo.com", 20),
				new Person("RamRam", "kumar", "ram@yahoo.com", 22),
				new Person("RamKiranRamKiran", "LaxmiKiran", "sita@yahoo.com", 30),
				new Person("RamKiranRamKiran", "Seth", "seth@yahoo.com", 50),
				new Person("SitaSita", "Kumar", "lakshman@yahoo.com", 50),
				new Person("GaneshSita", "Kumar", "ganesh@yahoo.com", 50));

				Iterable<Person> list = personService.saveAllPersons(personList);
				for (Person person : list) {
					System.out.println("Person Object" + person.toString());

				}
		
		}
	
	//findAllByID
	
	private void getPersons() {
		
		List<Integer> personList=new ArrayList<Integer>();
		
		personList.add(1);
		personList.add(2);
		personList.add(12);
		personList.add(5);
		personList.add(6);
		personList.add(20);
		personList.add(40);
		personList.add(11);
		personList.add(15);
		personList.add(3);
		personList.add(4);
		
		Iterable<Person> personsList=personService.getPersonsData(personList);
		for(Person person:personsList)
			System.out.println("Person Object: "+person.toString());
	}
	
	
	//Getting Data using Named Query.
	private void giveDataByName() {
		Iterable<Person> personList =personService.giveDataByName("Ram");
		for(Person person:personList) {
			System.out.println("Person Object"+person.toString());
		}
	}
	
	
	
}
