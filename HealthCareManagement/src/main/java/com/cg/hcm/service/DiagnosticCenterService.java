package com.cg.hcm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hcm.dao.DiagnosticCenterDAO;
import com.cg.hcm.dto.DiagnosticCenter;

@Service
//declaring this class as a service class.
public class DiagnosticCenterService 
{	
	@Autowired
	//Marks a constructor, field, setter method, or config method as to be autowired bySpring's dependency injection facilities
    DiagnosticCenterDAO diagnosticcenterdao;
    public void setDdao( DiagnosticCenterDAO diagnosticcenterdao) { this.diagnosticcenterdao=diagnosticcenterdao;}
    @Transactional
    //inserting diagnostic center into database
    public DiagnosticCenter insertDiagnosticcenter( DiagnosticCenter  diagnosticcenter)
    {
        return diagnosticcenterdao.save( diagnosticcenter);
    }
	
    @Transactional
    //deleting data from database
    public String deleteDiagnosticcenter(int centerId)
    {
    	diagnosticcenterdao.deleteById(centerId);
    	return "Diagnostic center with center ID:"+centerId+" "+"deleted Sucessfully";
    }
    @Transactional(readOnly=true)
    //getting all diagnostic centers
    public List<DiagnosticCenter> getDiagnosticcenters()
    {
    	return diagnosticcenterdao.findAll();
    }
   
    @Transactional(readOnly=true)
    //getting diagnostic by id
    public Optional<DiagnosticCenter> getDiagnosticcenter(int centerId)
    {
    	return diagnosticcenterdao.findById(centerId);
    }

    
}
