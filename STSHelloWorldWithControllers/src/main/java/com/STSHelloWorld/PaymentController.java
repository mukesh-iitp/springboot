package com.STSHelloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/payments")	
//http://localhost:8080/payments ==> PaymentController obj1=ioc.getPaymentController();
public class PaymentController {
	
	//Wallet Payment
	@RequestMapping(value="/wallet") //http://localhost:8080/payments/wallet
	public String getWalletPayment(){
		return "Wallet Payment...";
	}
	
	//CreditCard Payment
	@RequestMapping(value="/card") //http://localhost:8080/payments/card
	public String getCrediCardPayment(){
		return "Credit Card Payment...";
	}

}
