package com.domain.transaction.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_insurance")
public class Insurance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "insurance_id")
	private Integer insuranceID;
	
	private Integer empID;
	
	@Column(name = "healthInsuranceSchemeName")
	private String healthInsuranceSchemeName;
	
	private int coverageAmount;

	public Integer getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(Integer insuranceID) {
		this.insuranceID = insuranceID;
	}

	public Integer getEmpID() {
		return empID;
	}

	public void setEmpID(Integer empID) {
		this.empID = empID;
	}

	public String getHealthInsuranceSchemeName() {
		return healthInsuranceSchemeName;
	}

	public void setHealthInsuranceSchemeName(String healthInsuranceSchemeName) {
		this.healthInsuranceSchemeName = healthInsuranceSchemeName;
	}

	public int getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(int coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public Insurance(Integer insuranceID, Integer empID, String healthInsuranceSchemeName, int coverageAmount) {
		super();
		this.insuranceID = insuranceID;
		this.empID = empID;
		this.healthInsuranceSchemeName = healthInsuranceSchemeName;
		this.coverageAmount = coverageAmount;
	}
	
	public Insurance() {}

	@Override
	public String toString() {
		return "Insurance [insuranceID=" + insuranceID + ", empID=" + empID + ", healthInsuranceSchemeName="
				+ healthInsuranceSchemeName + ", coverageAmount=" + coverageAmount + "]";
	}
	
	
	

}
