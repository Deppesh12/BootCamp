package com.cg.hcm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hcm.dto.DiagnosticCenter;

@Repository
public interface DiagnosticCenterDAO extends JpaRepository<DiagnosticCenter, Integer> 
{

}