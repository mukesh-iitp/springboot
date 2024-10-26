package com.domain.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.transaction.dao.InsuranceDao;
import com.domain.transaction.model.Insurance;

@Service
public class InsuranceService {
	
	@Autowired
	private InsuranceDao insDao;
	
	public Insurance registerInsurance(Insurance insObj) {
		return insDao.save(insObj);
	}

}
