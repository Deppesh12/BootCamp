package com.cg.hcm.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity											 // Indicates bean class that is mapped with DataBase table
@Table(name="appointment")					    // Table name in Database

public class Appointment 
{
	@Id											// Indicates the field associated with it is a primary key in DB
	@Column(name="appointment_id")				// Indicates the column name in the DataBase table
	int appointmentId;
	@Column(name="status")
	String status;
	@Column(name="appointment_date")
	LocalDate date;
	@OneToOne									// Relationship between two classes
	@JoinColumn(name="test_id")					// foreign key reference in DB table
	Test test;
	@OneToOne									// Relationship between two classes
	@JoinColumn(name="center_id")				// foreign key reference in DB table
	DiagnosticCenter dc;
	public Appointment(){}
	public Appointment(int appointmentId, String status, LocalDate date, Test test, DiagnosticCenter dc) {
		super();
		this.appointmentId = appointmentId;
		this.status = status;
		this.date = date;
		this.test = test;
		this.dc = dc;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public DiagnosticCenter getDc() {
		return dc;
	}
	public void setDc(DiagnosticCenter dc) {
		this.dc = dc;
	}
	
	
}
