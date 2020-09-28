package com.cg.hcm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hcm.dao.TestCenterDAO;
import com.cg.hcm.dto.TestCenter;

@Service
//declaring this class as a service class.
public class TestCenterService 
{
	@Autowired
	//Marks a constructor, field, setter method, or config method as to be autowired bySpring's dependency injection facilities
	TestCenterDAO testcenterdao;
    public void setTcdao( TestCenterDAO testcenterdao) { this.testcenterdao=testcenterdao;}
    
    @Transactional(readOnly=true)
    //Getting all tests of a diagnostic center
    public Optional<List<Integer>> getTestCenter(int centerId)
    {
    	return testcenterdao.findByCenterId(centerId);
    }
    
    @Transactional
    //adding test to a diagnostic center
    public TestCenter addTestCenter(TestCenter testCenter)
    {
    	return testcenterdao.save(testCenter);
    }
    @Transactional(readOnly=true)
    //deleting a test from diagnostic center
    public String deleteTestCenter(int centerId,int testId )
    {
    	String message ="Test"+" "+testId+" "+"is sucessfully deleted from diagnostic center "+centerId;
    	TestCenter tc = testcenterdao.findByCenterIdAndTestId(centerId, testId);
    	testcenterdao.deleteByTestAndCenter(tc.getTestCenterId());

    	return message;
    }
}
