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

import com.cg.hcm.dto.Test;
import com.cg.hcm.service.TestService;




@RestController // creating RESTFul web services using Spring MVC
public class TestController 
{
	@Autowired // Auto wiring bean on setter method and constructor or a field
	TestService testService;
	public void setTestService(TestService testService)
	{
		this.testService = testService;
	}

	@DeleteMapping("/deleteTest/{testId}") //mapping HTTP DELETE requests onto deleteTest
	public String deleteTest(@PathVariable int testId) //bounding method parameter to this URL Template
	{
		return testService.deleteTest(testId); 
	}

	@PostMapping(value="/addTest",consumes="application/json") //it takes json file as the reference and consumes is for representing MIME media type or representations a resource can accept or consume
	//handling the HTTP POST requests matched with above URL 
	public ResponseEntity<String> insertTest(@RequestBody()Test test) // binding HTTPRequest Body to Domain Object
	{
		try
		{
			String message="Test Inserted Successfully";
			if(testService.insertTest(test)==null) //if the test inserted is null the the message failed is generated
				message="Test Insertion Failed";
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>(ex.getMessage()+" Insertion Failed",HttpStatus.BAD_REQUEST);	
		}
	}
	@GetMapping("/getTests") //handling HTTP GET requests matched with above URL	
	public List<Test> getTests()
	{
		return testService.getTests();
	}
	@GetMapping(value="/getTest/{testId}",produces="application/json")//specifying representations a resource can produce and send back to client
	public ResponseEntity<Optional<Test>> getTestDetails(@PathVariable int testId)
	{
		Optional<Test> test =  testService.getTest(testId); // Optional is a new container type that wraps a single value if available
		
		if(test.isPresent())
			return new ResponseEntity<Optional<Test>>(test,HttpStatus.OK);
		return new ResponseEntity<Optional<Test>>(test,HttpStatus.NOT_FOUND);
	}

	@GetMapping(value="/getTestsById/{testIds}",produces="application/json")
	public ResponseEntity<List<Test>> getMultipleTestById(@PathVariable int testIds[])
	{
		List<Test> test =  testService.getTestById(testIds);
		if(!test.isEmpty())
			return new ResponseEntity<List<Test>>(test,HttpStatus.OK);
		return new ResponseEntity<List<Test>>(test,HttpStatus.NOT_FOUND);
	}

}