package com.cg.hcm.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.hcm.dto.TestCenter;
@Repository 
//indicating that TestDao is a repository
public interface TestCenterDAO extends JpaRepository<TestCenter, Integer>
{
	@Query("select t.testId from TestCenter t where t.centerId=:centerId")
	public Optional<List<Integer>> findByCenterId(@Param("centerId")Integer centerId);
	@Query("select t from TestCenter t where t.centerId=:centerId and t.testId=:testId")
	//query to find the test and diagnostic center
	public TestCenter findByCenterIdAndTestId(@Param("centerId")Integer centerId,@Param("testId")Integer testId);
	@Modifying
	@Query("delete from TestCenter t where t.testcenterId=:testcenterId") 
	//query to delete test from diagnostic center
	public void deleteByTestAndCenter(@Param("testcenterId")Integer testcenterId);
}
