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
@Table(name="test_center")
//Specifing the table name in database
@SequenceGenerator(name = "tcId",allocationSize = 1)
public class TestCenter 
{
    @Id
    // Indicates the field associated with it is a primary key in DB
    @Column(name="testcenter_Id")
    // Indicates the column name in the DataBase table
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tcId")
    //Generating values of center_id
    private int testcenterId;
	@Column(name="test_id")
	private Integer testId;
	@Column(name="center_id")
	private Integer centerId;
	
	public TestCenter() {}
	//default constructor
	public TestCenter(int testcenterId,Integer testId, Integer centerId) 
	{
		this.testcenterId=testcenterId;
		this.testId = testId;
		this.centerId = centerId;
	}
	
	//Getters and Setters
	public int getTestCenterId() {
		return testcenterId;
	}
	public void setTestCenterId(int testcenterId) {
		this.testcenterId = testcenterId;
	}
	public Integer getTestId() {
		return testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public Integer getCenterId() {
		return centerId;
	}
	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}
	
	
	

}
