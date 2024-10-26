package com.domain.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.transaction.dao.EmployeeDao;
import com.domain.transaction.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao empDao;
	
	public Employee saveEployee(Employee emp) {
		return empDao.save(emp);
	}

}
