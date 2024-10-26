package com.STSHelloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/loan")
//http://localhost:8080/loan ==> LoanController obj3=ioc.getLoanController();
public class LoanController {
	
	//savings Account
	@RequestMapping(value="/savings") //http://localhost:8080/loan/savings
	//http://localhost:8080/loan/savings ==> obj3.getSavingAcount(); 
	public String getSavingAccount() {
		return "Saving Account...";
	}
		
	
	//current Account
	@RequestMapping(value="/current") //http://localhost:8080/loan/current
	//http://localhost:8080/loan/current ==> obj3.getCurrentAcount(); 
	public String getCurrentAccount() {
		return "Current Account...";
	}
	
	//HomeLoan
	@RequestMapping(value="/homeloan") //http://localhost:8080/loan/homeloan
	//http://localhost:8080/loan/HomeLoan ==> obj3.getHomeLoan(); 
	public String getHomeLoan() {
		return "Home Loan...";
	}
	

}
