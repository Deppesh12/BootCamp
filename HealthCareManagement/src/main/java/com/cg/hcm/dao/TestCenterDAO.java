package com.cg.hcm.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.hcm.dto.TestCenter;

public interface TestCenterDAO extends JpaRepository<TestCenter, Integer>
{
	@Query("select t.testId from TestCenter t where t.centerId=:centerId")
	public Optional<List<Integer>> findByCenterId(@Param("centerId")Integer centerId);
	@Query("select t from TestCenter t where t.centerId=centerId and t.testId=testId")
	public TestCenter findByCenterIdAndTestId(@Param("centerId")Integer centerId,@Param("testId")Integer testId);	
}
