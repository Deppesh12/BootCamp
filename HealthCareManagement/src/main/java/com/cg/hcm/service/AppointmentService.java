package com.cg.hcm.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hcm.dao.AppointmentDAO;
import com.cg.hcm.dto.Appointment;

@Service
public class AppointmentService 
{
	@Autowired									// Injectes dependencies
	AppointmentDAO adao;

	public void setAdao(AppointmentDAO adao) {
		this.adao = adao;
	}
	
	@Transactional
	public Appointment makeAnAppointment(Appointment a)				// Method to add an appointment made by user
	{
		return adao.save(a);
	}
	
	@Transactional
	public Optional<Appointment> getAppointment(int appointment_id)			// method to get an appointment by appointmentId
	{
		return adao.findById(appointment_id);
	}
	
	@Transactional
	public String deleteAppointment(int appointmentId)				// method to delete an appointment by appointmentId
	{
		adao.deleteById(appointmentId);
		return "Delete Successfully";
	}
	
	@Transactional
	public List<Appointment> getAllAppointments()					// method to display all the appointments made by the user
	{
		return adao.findAll();
	}
}
