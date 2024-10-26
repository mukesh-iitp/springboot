package com.domain.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.domain.transaction.model.Employee;
import com.domain.transaction.model.Insurance;
import com.domain.transaction.service.OrganizationService;

@SpringBootApplication
public class TransactionMgmtApplication implements CommandLineRunner {

	@Autowired
	private OrganizationService orgService;

	public static void main(String[] args) {
		SpringApplication.run(TransactionMgmtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Test Code
		Employee emp = new Employee();

		/*
		 * emp.setEmpName("Chandana"); 
		 * Insurance employeeHealthInsurance=new Insurance();
		 * employeeHealthInsurance.setHealthInsuranceSchemeName("CovidCoverage");
		 * employeeHealthInsurance.setCoverageAmount(1000000);
		 */

		
		/*
		 * emp.setEmpName("Gopi"); 
		 * Insurance employeeHealthInsurance=new Insurance();
		 * employeeHealthInsurance.setHealthInsuranceSchemeName("Test");
		 * employeeHealthInsurance.setCoverageAmount(1000000);
		 */
		
		//success case:
		/*
		//emp.setEmpName("Gopi"); 
		emp.setEmpName("Raju");
		Insurance employeeHealthInsurance=new Insurance();
		employeeHealthInsurance.setHealthInsuranceSchemeName("FamilyTopUp");
		employeeHealthInsurance.setCoverageAmount(1000000);
		*/
		
		//Failure case:
		emp.setEmpName("Akil");
		Insurance employeeHealthInsurance=new Insurance();
		employeeHealthInsurance.setHealthInsuranceSchemeName("Test");
		employeeHealthInsurance.setCoverageAmount(1000000);
		

		orgService.onBoardEmployee(emp, employeeHealthInsurance);

	}

}
