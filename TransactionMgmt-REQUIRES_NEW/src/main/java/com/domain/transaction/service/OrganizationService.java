package com.domain.transaction.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.domain.transaction.model.Audit;
import com.domain.transaction.model.Employee;
import com.domain.transaction.model.Insurance;

@Service
public class OrganizationService {

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private InsuranceService insService;
	
	@Autowired
	private AuditService auditService;
	
	@Transactional(propagation = Propagation.REQUIRED)
	/*
	 * 1) Need to update to Database to start Transaction Block
	 * 2) Ensure that all DML statements should propagate from this block only.
	 * 3) No need of writing commit/roll back==> Framework will take care
	 * 
	 * 4) Employee, Insurance in one Transaction Block => Commit/Rollback
	 * 5) Audit should be in other transaction block => Always Commit
	 */  
	public void onBoardEmployee(Employee empObj, Insurance insObj) {
		Employee employee = empService.saveEployee(empObj);	//T1
		
		if(employee.getEmpID()!=null) {
			//T2
			auditService.saveAudit(new Audit("Employee creation is success for "+employee.getEmpName()));
			insObj.setEmpID(employee.getEmpID());
		}
		else {
			//T2
			auditService.saveAudit(new Audit("Employee creation is Failed for "+employee.getEmpName()));
		}
		
		if (insObj.getHealthInsuranceSchemeName().length() <= 4) {
			//T3
			auditService.saveAudit(new Audit("Insurance creation is Failed for  with insurance Name ....."
					+ insObj.getHealthInsuranceSchemeName() + ".....For the Employe ...." + employee.getEmpName()));
			throw new RuntimeErrorException(null, "Error in Insurance");
		}

		else {
			//T1

			insService.registerInsurance(insObj);
			//T3
			auditService.saveAudit(new Audit("Insurance creation is Sucess for " + employee.getEmpName()));
		}
	}
	
}
