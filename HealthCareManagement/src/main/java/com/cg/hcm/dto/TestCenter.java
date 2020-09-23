package com.cg.hcm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="test_center")
@SequenceGenerator(name = "tcId",allocationSize = 1)
public class TestCenter 
{
    @Id
    @Column(name="tc_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tcId")
    private int tcId;
	@Column(name="test_id")
	private Integer testId;
	@Column(name="center_id")
	private Integer centerId;
	public TestCenter() {}
	public TestCenter(int tcId,Integer testId, Integer centerId) 
	{
		this.tcId=tcId;
		this.testId = testId;
		this.centerId = centerId;
	}
	
	public int getTcId() {
		return tcId;
	}
	public void setTcId(int tcId) {
		this.tcId = tcId;
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
