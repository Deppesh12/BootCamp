package com.cg.hcm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hcm.dao.TestCenterDAO;
import com.cg.hcm.dto.TestCenter;

@Service
public class TestCenterService 
{
	@Autowired
	TestCenterDAO tcdao;
    public void setTcdao( TestCenterDAO tcdao) { this.tcdao=tcdao;}
    
    @Transactional(readOnly=true)
    /*public TestCenter getTestCenter(int centerId)
    {
    	return tcdao.findByCenterId(centerId);
    }*/
    public Optional<List<Integer>> getTestCenter(int centerId)
    {
    	return tcdao.findByCenterId(centerId);
    }
    
    @Transactional
    public TestCenter addTestCenter(TestCenter testCenter)
    {
    	return tcdao.save(testCenter);
    }
    @Transactional(readOnly=true)
    public String deleteTestCenter(int centerId,int testId )
    {
    	String message ="";
    	TestCenter testCenter = tcdao.findByCenterIdAndTestId(centerId, testId);
    	if(testCenter!=null)
    	{
    		tcdao.delete(testCenter);
    		message += "Test_center deleted";
     	}
    	else
    		message += "Cannot add Test_center";
    	return message;
    }
}
