package com.cg.hcm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hcm.dto.TestCenter;
import com.cg.hcm.service.TestCenterService;

@RestController
public class TestCenterController 
{
	@Autowired
	//Auto wiring bean on setter method and constructor or a field
	TestCenterService testCenterService;
	public void setTestCenterService(TestCenterService testCenterService)
	{
		this.testCenterService = testCenterService;
	}
	@DeleteMapping("/deleteTestCenter/{testId}/{centerId}")//mapping HTTP DELETE request onto deleteTestCenter
	//handling the HTTP DELETE requests for above URL 
	public String deleteTestCenter(@PathVariable int testId,@PathVariable int centerId)
	{
	   return testCenterService.deleteTestCenter(centerId,testId); 
	}
	
	@PostMapping(value="/addTestCenter",consumes="application/json")//Taking Input from JSON file
	//handling the HTTP POST requests for above URL 
	public ResponseEntity<String> insertTestCenter(@RequestBody()TestCenter testCenter)
	{
		String message;
		try
		{
			message="Test Inserted Successfully";
			System.out.println(testCenter.getCenterId());
			if(testCenterService.addTestCenter(testCenter)==null)
			{
				message="Test Insertion Failed";
				return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
			}
			else
			{
				return new ResponseEntity<String>(message+" with center ID: "+testCenter.getCenterId()+" "+"and test ID: "+testCenter.getTestId(),HttpStatus.OK);
				   
			}
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>(ex.getMessage()+" Insertion Failed",HttpStatus.BAD_REQUEST);	
		}
	}
	
	@GetMapping(value="/getTestCenters/{centerId}",produces="application/json")
	//handling the HTTP GET request for above URL 
	public ResponseEntity<Optional<List<Integer>>> getTestCenterDetails(@PathVariable int centerId)
	{
		Optional<List<Integer>> testCenter =  testCenterService.getTestCenter(centerId);
		if(testCenter.isPresent())
			return new ResponseEntity<Optional<List<Integer>>>(testCenter,HttpStatus.OK);
		return new ResponseEntity<Optional<List<Integer>>>(testCenter,HttpStatus.NOT_FOUND);
	}

}
