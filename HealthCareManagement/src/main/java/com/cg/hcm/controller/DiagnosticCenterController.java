package com.cg.hcm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hcm.dto.DiagnosticCenter;
import com.cg.hcm.service.DiagnosticCenterService;

@RestController
//marking class as controller
public class DiagnosticCenterController 
{
	@Autowired
	//Autowire DiagnosticCenterService Class 
	DiagnosticCenterService diagnosticcenterService;
	public void setDiagnosticcenterService(DiagnosticCenterService diagnosticcenterService)
	{
		this.diagnosticcenterService=diagnosticcenterService;
	}
	

   @PostMapping(value="/addDiagnosticcenter",consumes="application/json")
   //Inserting new diagnostic center into database
   public ResponseEntity<String> insertDiagnosticcenter(@RequestBody()DiagnosticCenter diagnosticcenter)
   {
	   try
	   {
	   String message="center Inserted Successfully";
	  if(diagnosticcenterService.insertDiagnosticcenter(diagnosticcenter)==null)
		   message="Center Insertion Failed";
	   return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
	   }
	   catch(Exception ex)
	   {
			return new ResponseEntity<String>(ex.getMessage()+" Insertion Failed",HttpStatus.BAD_REQUEST);
			 
	   }
	   
   }
   
   @DeleteMapping("/deleteDiagnosticcenter/{centerId}")
   //Deleting a diagnostic Center form database
   public String deleteDiagnosticcenter(@PathVariable int centerId)
   {
	   return diagnosticcenterService.deleteDiagnosticcenter(centerId); 
   }
   
   @GetMapping(value="/getDiagnosticcenter/{centerId}",produces="application/json")
   public ResponseEntity<Optional<DiagnosticCenter>> getDiagnosticcenterDetails(@PathVariable int centerId)
   {
 	  Optional<DiagnosticCenter> diagnosticcenter =  diagnosticcenterService.getDiagnosticcenter(centerId);
 	  if(diagnosticcenter.isPresent())
 		  return new ResponseEntity<Optional<DiagnosticCenter>>(diagnosticcenter,HttpStatus.OK);
 	  return new ResponseEntity<Optional<DiagnosticCenter>>(diagnosticcenter,HttpStatus.NOT_FOUND);
   }
   
   
   
   
}
