package com.cg.hcm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hcm.dto.Appointment;
import com.cg.hcm.service.AppointmentService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AppointmentController 
{
	@Autowired															// Injectes dependencies automatically
	AppointmentService as;

	public void setAs(AppointmentService as) {
		this.as = as;
	}
	
	@PostMapping("/addAppointment")
	public ResponseEntity<String> addAppointment(@RequestBody() Appointment ap)			// Adds appointment details
	{																					// Reponse Entity hepls to display status of the body
		try
		{
			as.makeAnAppointment(ap);
			return new ResponseEntity<String>("Apppointment made",HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>("Appointment not added",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAppointment/{appointmentId}")															// Retrieves Appointment details based on appointmentId
	public ResponseEntity<Optional<Appointment>> getAppointment(@PathVariable int appointmentId)
	{
		Optional<Appointment> appt = as.getAppointment(appointmentId);
		if(appt.isPresent())
			return new ResponseEntity<Optional<Appointment>>(appt,HttpStatus.OK);
		else
			return new ResponseEntity<Optional<Appointment>>(appt,HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/deleteAppointment/{appointmentId}")
	public ResponseEntity<String> deleteAppointment(@PathVariable int appointmentId)		// Deleting an appointment
	{																						
		try
		{
			as.deleteAppointment(appointmentId);
			return new ResponseEntity<String>("Deleted Sucessfully",HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>("Deletion Failed",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAllAppointments")													// Retrieves all the appointments made by users
	public List<Appointment> getAllAppointments()
	{
		return as.getAllAppointments();
	}
}
