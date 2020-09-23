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
    DiagnosticCenterDAO ddao;
    public void setDdao( DiagnosticCenterDAO ddao) { this.ddao=ddao;}
    @Transactional
    //inserting data into database
    public DiagnosticCenter insertDiagnosticcenter( DiagnosticCenter  diagnosticcenter)
    {
        return ddao.save( diagnosticcenter);
    }
	
    @Transactional
    //deleting data from database
    public String deleteDiagnosticcenter(int centerId)
    {
    	ddao.deleteById(centerId);
    	return "center Deleted";
    }
   
    @Transactional(readOnly=true)
    public Optional<DiagnosticCenter> getDiagnosticcenter(int centerId)
    {
    	return ddao.findById(centerId);
    }

    
}
