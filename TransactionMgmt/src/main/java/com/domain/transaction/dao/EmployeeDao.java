package com.domain.transaction.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.domain.transaction.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer>{

}
