package com.domain.transaction.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.domain.transaction.model.Audit;

@Repository
public interface AuditDao extends CrudRepository<Audit, Integer>{
	
}
