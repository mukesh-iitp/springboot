package com.domain.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.domain.transaction.dao.AuditDao;
import com.domain.transaction.model.Audit;

@Service
public class AuditService{
	
	@Autowired
	private AuditDao auditDao;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	//This will always create a new transaction block
	public Audit saveAudit(Audit auditObj){
		return auditDao.save(auditObj);
	}

}
