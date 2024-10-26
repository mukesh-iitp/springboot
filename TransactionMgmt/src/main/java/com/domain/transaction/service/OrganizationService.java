package com.domain.transaction.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.transaction.model.Employee;
import com.domain.transaction.model.Insurance;

@Service
public class OrganizationService {

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private InsuranceService insService;
	
	@Transactional
	/*
	 * 1) Need to update to Database to start Transaction Block
	 * 2) Ensure that all DML statements should propagate from this block only.
	 * 3) No need of writing commit/roll back==> Framework will take care
	 */  
	public void onBoardEmployee(Employee empObj, Insurance insObj) {
		empService.saveEployee(empObj);
		
		if(insObj.getHealthInsuranceSchemeName().length()<=4) {
			throw new RuntimeErrorException(null, "Error in Insurance");
		}else {
			insObj.setEmpID(empObj.getEmpID());
			
			insService.registerInsurance(insObj);	//DML2
		}
	}
	
}
