package com.NamedQuery.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.NamedQuery.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long>{
	
	//Name Query abstract method
	
	public  List<Object[]> findMaxSalariesByDept(List<String> deptName);
	

}
