package com.cg.hcm.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hcm.dao.TestDao;
import com.cg.hcm.dto.Test;



@Service
public class TestService 
{
	@Autowired
	TestDao tdao; 
	public void setTdao(TestDao tdao)
	{
		this.tdao = tdao;
	}
	
	@Transactional
	public Test insertTest(Test test)
	{
		return tdao.save(test);  //Diagnosis test will be added 
	}
	
	 @Transactional
	    public String deleteTest(int testId)
	    {
	    	tdao.deleteById(testId);
	    	return "test Deleted";    //Diagnosis test will be deleted
	    }
	 @Transactional(readOnly=true)
	    public List<Test> getTests()
	    {
	    	return tdao.findAll();   //List of tests will be retrieved
	    }
	 @Transactional(readOnly=true)
	    public Optional<Test> getTest(int testId)
	    {
	    	return tdao.findById(testId);   //Particular Test will be retrieved based on testId
	    }
	 
	 @Transactional(readOnly=true)
	 public List<Test> getTestById(int testIds[])
	 {	 
		List<Test> results = new ArrayList<Test>();
 			for (int id : testIds) 
 			{
 				tdao.findById(id).ifPresent(results::add);  //tests will be allotted into Arraylist
 			}
 		return results;
	} 
}
