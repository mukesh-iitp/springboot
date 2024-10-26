package com.domain.transaction.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="audit")
public class Audit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "audit_id")
	private Integer auditID;
	
	private String auditDescription;
	//Employee Ramu created successfully
	//Insurance of Ramu failed with insurance name "Test"

	public Integer getAuditID() {
		return auditID;
	}

	public void setAuditID(Integer auditID) {
		this.auditID = auditID;
	}

	public String getAuditDescription() {
		return auditDescription;
	}

	public void setAuditDescription(String auditDescription) {
		this.auditDescription = auditDescription;
	}

	public Audit(String auditDescription) {
		super();
		this.auditDescription = auditDescription;
	}
	
	public Audit() {
		
	}

	@Override
	public String toString() {
		return "Audit [auditID=" + auditID + ", auditDescription=" + auditDescription + "]";
	}	

}
