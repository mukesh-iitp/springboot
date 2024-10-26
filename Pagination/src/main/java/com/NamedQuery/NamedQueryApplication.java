package com.NamedQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.EnableAsync;

import com.NamedQuery.model.Book;
import com.NamedQuery.model.CustomType;
import com.NamedQuery.model.Employee;
import com.NamedQuery.model.Person;
import com.NamedQuery.model.Publisher;
import com.NamedQuery.service.PersonService;

@SuppressWarnings("unused")
@SpringBootApplication
@EnableAsync	//This annotation will create the multi threading infrastructure.
public class NamedQueryApplication implements CommandLineRunner{

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(NamedQueryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		//-- Test Codes --

		//saveAll


		//findAllById

		//createPersons();

		//getPersons();

		//findByFirstName();
		//findByFirstNameAndLastName();
		//findByFirstNameOrLastName();
		//findByLastNameOrderByCreatedDateDesc();
		//findByAgeLessThanEqual();
		//findByFirstNameLike();
		//findByLastNameAndAgeLessThanEqual();

		//findByCreatedDateBetweenwithTime();
		//giveDataByName();
		//saveBookPublishers();
		//getAllBooksbyName();

		//createEmployees();
		//findMaxSalariesbyDept();
		
		//giveFewColumns();
		
		
		//findPersonInfobyFirstNameorEmail();
		//findPersonINfobyFirstname();
		
		//dispPagination();
		
		//runsync();
		//runAsync();
		
		dynamicUpdateTest();

	}
	
	private void dynamicUpdateTest() {
		Person dbperson = personService.findByLastNameAndFirstName("kumar", "Ram");

		dbperson.setEmail("ram@gmail.com");
		
		personService.savePerson(dbperson);

	}
	
	
	private void runsync() throws InterruptedException, ExecutionException {

		long start = System.currentTimeMillis();  //120 MS
		// Kick of multiple, asynchronous lookups
		List<Person> person1 = personService.findByEmail("kiran@gmail.com");
		// The following statement will be printed only after the
		// execution of above method findByEmail
		System.out.println("Person1 Call Completed");

		List<Person> personson2 = personService.findByEmail("laxmikiran@gmail.com");
		System.out.println("Person2 Call Completed");

		List<Person> personson3 = personService.findByEmail("sita@gmail.com");
		System.out.println("personson3 Call Completed");

		List<Person> personson4 = personService.findByEmail("lakshman@gmail.com");
		System.out.println("personson4 Call Completed");


		person1.forEach(System.out::println);
		personson2.forEach(System.out::println);

		personson3.forEach(System.out::println);

		personson4.forEach(System.out::println);

		System.out.println("Total Time took: " + (System.currentTimeMillis() - start));

	}

	private void runAsync() throws InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		// Kick of multiple, asynchronous lookups

		// main Thread is executing the runAsynch method
		CompletableFuture<Person> obj1 = personService.findByemail("kiran@gmail.com");
		System.out.println("Person1 Call Done");

		CompletableFuture<Person> obj2 = personService.findByemail("laxmikiran@gmail.com");
		System.out.println("Person2 Call Done");

		CompletableFuture<Person> obj3 = personService.findByemail("sita@gmail.com");
		System.out.println("Person3 Call Done");

		CompletableFuture<Person> obj4 = personService.findByemail("lakshman@gmail.com");
		System.out.println("Person4 Call Done"); //This work given to Thrad4  by Main Thread

		///
		//	1000 lines of code

		//obj2




		// Wait until they are all done
		CompletableFuture.allOf(obj1, obj2, obj3, obj4).join();

		// Print results, including elapsed time

		System.out.println("--> " + obj1.get());
		System.out.println("--> " + obj2.get());
		System.out.println("--> " + obj3.get());
		System.out.println("--> " + obj4.get());

		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
	}

	
	private void dispPagination() {
		
		System.out.println("Pagination without sorting");
		
		List<Person> noSortList=personService.findByLastName("kumar", PageRequest.of(0, 4));
		//select * from person where last_name="kumar" where ROWNUMBER>=0 and ROWNUMBER<=4
		
		noSortList.forEach(System.out::println);
		
		
		System.out.println("Pagination with sorting");
		System.out.println("First Page ----------------");
		
		Iterable<Person> list=personService.findByLastName("kumar", PageRequest.of(0,3,Direction.ASC,"firstName"));
		//Select * from Person WHERE last_name='kumar' and ROWNUMBER>=0 AND ROWNUMBER<=3
		//ORDER BY first_name ASC;
		
		//0 -> Offset
		//3 -> Page size
		//Order of Sorting ASC/DESC
		//Which column name order
		
		//for(Person person:list) {
		//	System.out.println("Person Object "+ personService.toString());		
		//}
		
		list.forEach(System.out::println);
		
		
		System.out.println("Second Page ----------------");
		Iterable<Person> secondList=personService.findByLastName("kumar", PageRequest.of(1,3,Direction.ASC,"firstName"));
		//new PageRequest(1,2, Direcion.ASC, "firstName");
		//offset*pagesize+1 ->3 ->3 records
		secondList.forEach(System.out::println);
		
		
		System.out.println("Third Page ----------------");
		Iterable<Person> thirdList=personService.findByLastName("kumar", PageRequest.of(2,3,Direction.ASC,"firstName"));
		thirdList.forEach(System.out::println);
		
		System.out.println("Fourth Page ----------------");
		Iterable<Person> fourthList=personService.findByLastName("kumar", PageRequest.of(3,3,Direction.ASC,"firstName"));
		fourthList.forEach(System.out::println);
		
	}

	private void findPersonInfobyFirstNameorEmail(){
		Iterable<Person> personList=personService.findPersonInfobyFirstNameorEmail("Ram", "ram@gmail.com");
		for(Person person:personList)
			System.out.println("Person Object "+ person.toString());
	}
	
	private void findPersonINfobyFirstname(){
		Iterable<Person> personList=personService.findPersonINfobyFirstname("Ram");
		for(Person person:personList)
			System.out.println("Person Object "+person.toString());
	}
		
	
	private void giveFewColumns() {
		Iterable<CustomType> personsList = personService.giveFewColumns("Ram");
		for (CustomType person : personsList) {
			System.out.println("Person Object" + person.toString());
		}		
	}

	private void findMaxSalariesbyDept() {

		List<Object[]> list = personService.findMaxSalariesByDept(
				Arrays.asList("Admin", "IT", "HR"));
		list.forEach(arr -> {
			System.out.println(Arrays.toString(arr));
		}
		);
	}

	private void createEmployees() {
		List<Employee> empList = Arrays.asList(
				//Admin Dept
				Employee.create("Ram", "Admin", 20000),
				Employee.create("Gopi", "Admin", 35000),

				//Sales Dept
				Employee.create("Sita", "Sale", 10000),
				Employee.create("Ganesh", "Sale", 30000),

				//IT Dept
				Employee.create("Laxman", "IT", 40000),
				Employee.create("Seenu", "IT", 25000),

				//HR Dept
				Employee.create("Swathi", "HR", 80000),
				Employee.create("Sneha", "HR", 65000)

		);

		Iterable<Employee> list = personService.saveAllEmployees(empList);
		for (Employee emp : list) {
			System.out.println("Employee Object" + emp.toString());

		}
	}

	private void saveBookPublishers() {

		Publisher publisherA = new Publisher("AbdulKalam");
		Publisher publisherB = new Publisher("Stephen Kovey");
		Publisher publisherC = new Publisher("ChetanBagath");
		Publisher publisherD = new Publisher("Author2");
		Publisher publisherE = new Publisher("Author3");
		Publisher publisherF = new Publisher("Nazir");

		//One to One
		Book bookA = new Book("WingsofFire", new HashSet<>(Arrays.asList(publisherA)));
		Book bookB = new Book("SevenHabits", new HashSet<>(Arrays.asList(publisherB)));
		Book bookC = new Book("TwoStates", new HashSet<>(Arrays.asList(publisherC)));

		//One to Many from Book to Publisher
		Book bookD = new Book("Book2", new HashSet<>(Arrays.asList(publisherD, publisherE)));

		//One to Many from Publisher to Book
		Book bookE = new Book("Book5", new HashSet<>(Arrays.asList(publisherF)));
		Book bookF = new Book("Book6", new HashSet<>(Arrays.asList(publisherF)));

		personService.saveAllBooks(Arrays.asList(bookA, bookB, bookC, bookD, bookE, bookF));

		// bookService.saveBooks(Arrays.asList(bookA, bookB));

		// fetch all publishers
		for (Book book : personService.getAllBooks()) {
			System.out.println(book.toString());
		}

	}


	public void getAllBooksbyName() {

		Iterable<Book> books=personService.listBooksWithName("Book2");
		// fetch all publishers
				for (Book book : books) {
					System.out.println(book.toString());
				}
	}

	private void findByCreatedDateBetweenwithTime() {
		//2021-10-18 21:57:03
		Iterable<Person> personsList = personService.findByCreatedDateBetween(
				getDatewithTime("2022-09-05 06:26:53"),
				getDatewithTime("2022-09-06 06:26:58"));

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	private Date getDatewithTime(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			return format.parse(dateString);
		} catch (ParseException pe) {
			throw new RuntimeException(pe);
		}
	}

	private void findByFirstName() {
		Iterable<Person> personsList = personService.findByFirstName("Ram");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void findByFirstNameAndLastName() {
		Person person = personService.findByLastNameAndFirstName("kumar", "Ram");

		System.out.println("Person Object" + person.toString());

	}
	private void findByFirstNameOrLastName() {
		Iterable<Person> personsList = personService.findByLastNameOrFirstName("kumar", "Ram");

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	private void findByLastNameOrderByCreatedDateDesc(){

		Iterable<Person> personsList = personService.findByLastNameOrderByCreatedDateDesc("kumar");

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	private void findByAgeLessThanEqual() {
		Iterable<Person> personsList = personService.findByAgeLessThanEqual(40);
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}


	private void findByFirstNameLike() {
		Iterable<Person> personsList = personService.findByFirstNameLike("%Kiran%");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void findByLastNameAndAgeLessThanEqual(){


		Iterable<Person> personsList = personService.findByLastNameAndAgeLessThanEqual("kumar",40);
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}
	private void createPersons() {

		/*
		 * List<Person> personList=new ArrayList<Person>();
		 *
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 *
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 *
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 *
		 * personService.saveAllpersons(personList);
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


	//findAllById

	private void getPersons() {
		List<Integer> personList = new ArrayList<Integer>();
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
		Iterable<Person> personsList = personService.getPersonsData(personList);
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void giveDataByName() {
		Iterable<Person> personsList = personService.giveDataByName("Ram");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

}
