package com.derivedmethod.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tbl_person")

@NamedQueries(value= {
		
		//Implementation layer
		//NamedQuery1
		@NamedQuery(name="Person.giveDataByName", query= "select p from Person p where p.firstName= ?1"),
		
		//NamedQuery2
		@NamedQuery(name="Person.giveFewColumns", query="select p.firstName, p.lastName from Person p where p.firsName=?1")
})

public class Person {
	
	/*
	 * IDENTITY ==> Complete Database System will manage the sequence for primary key etc.
	 * JPA will not play any role in the this generation.
	 * 
	 */
	
	@Id
	@Column(name="person_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="email")
	private String email;

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Person(String firstName, String lastName, String email,Integer age) {
		super();
		//this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.createdDate = new Date();
		this.email = email;
	}
	
	public Person() {}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", createdDate=" + createdDate + ", email=" + email + "]";
	}
	
	
}
