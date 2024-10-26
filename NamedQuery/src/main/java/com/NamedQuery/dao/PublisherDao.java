package com.NamedQuery.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.NamedQuery.model.Publisher;

@Repository
public interface PublisherDao extends CrudRepository<Publisher, Integer>{
	
	
	
	
}
