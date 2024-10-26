package com.domain.transaction.dao;

import org.springframework.data.repository.CrudRepository;

import com.domain.transaction.model.Insurance;

public interface InsuranceDao extends CrudRepository<Insurance, Integer> {
	

}
