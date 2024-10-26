package com.NamedQuery.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tbl_book")

//NamedQuery for Retrieving Book, Book_Publisher and Publisher Details with Book Name as Input

@NamedQueries(value= {

		//Implementation Layer
		//NamedQuery1
		@NamedQuery(name="Book.listBooksWithName",
				query ="SELECT  DISTINCT b from Book b  Join b.publishers   p where b.bookName=?1 ")

		//NamedQuery2
})

public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="book_id")
	private Integer bookId;
	
	@Column(name="book_name")
	private String bookName;
	
	//join table
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable
	(
		name = "book_publisher",
		joinColumns = @JoinColumn(name = "book_Id", referencedColumnName = "book_Id"),
		inverseJoinColumns = @JoinColumn(name = "publisher_Id", referencedColumnName = "pub_Id")
	)
	private Set<Publisher> publishers;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Set<Publisher> getPublishers() {
		return publishers;
	}

	public void setPublishers(Set<Publisher> publishers) {
		this.publishers = publishers;
	}

	public Book(String bookName, Set<Publisher> publishers) {
		super();
		this.bookName = bookName;
		this.publishers = publishers;
	}
	
	public Book() {}

	@Override
	public String toString() {
		
		String result = String.format("Book Data [id=%d, name=%s]%n", bookId, bookName);
		//Book Data[id=1, name='Book A']
		
		if(publishers != null) {
			for(Publisher publisher : publishers)
			{
				result+=String.format("Publisher [id=%d, name=%s]%n", publisher.getPubId(), publisher.getPubName());
			}
		}
		return result;

	}
	
	
	

}
