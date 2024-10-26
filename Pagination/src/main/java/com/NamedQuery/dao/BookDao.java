package com.NamedQuery.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.NamedQuery.model.Book;

@Repository
public interface BookDao extends CrudRepository<Book, Integer>{
	
	public Iterable<Book> listBooksWithName(String bookName);

}
