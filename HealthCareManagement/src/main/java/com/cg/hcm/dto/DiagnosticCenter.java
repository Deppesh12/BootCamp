package com.cg.hcm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//mapping  entity class to table in sql.
@Table(name="diagnostic_center")
//Specifing the table name in database
@SequenceGenerator(name = "cenId",initialValue = 100,allocationSize = 1)
//Defining a generator
public class DiagnosticCenter 
{
	@Id
	// Indicates the field associated with it is a primary key in DB
	@Column(name = "center_id")
	// Indicates the column name in the DataBase table
	@GeneratedValue(generator = "cenId",strategy = GenerationType.SEQUENCE)
	//Generating values of center_id
	private Integer centerId;
	@Column(name = "center_name")
	private String centerName;
	@Column(name = "center_area")
	private String centerArea;
	
	public DiagnosticCenter() {	}
	//default constructor

	public DiagnosticCenter(Integer centerId, String centerName, String centerArea) {
		this.centerId = centerId;
		this.centerName = centerName;
		this.centerArea = centerArea;
	}
    
	//Getters and Setters
	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterArea() {
		return centerArea;
	}

	public void setCenterArea(String centerArea) {
		this.centerArea = centerArea;
	}	
}