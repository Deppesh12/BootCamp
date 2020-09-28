package com.cg.hcm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hcm.dto.Users;
@Repository //indicating that TestDao is a repository
public interface UsersDao extends JpaRepository<Users,Integer> //performing CRUD operations on User
{

}