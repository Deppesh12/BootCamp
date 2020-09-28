package com.cg.hcm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.hcm.dto.Appointment;

public interface AppointmentDAO extends JpaRepository<Appointment, Integer>
{

}
