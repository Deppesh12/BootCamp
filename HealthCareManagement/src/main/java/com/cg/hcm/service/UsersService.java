package com.cg.hcm.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.hcm.dao.UsersDao;
import com.cg.hcm.dto.Users;
@Service //Indicates that an annotated class is a Service
public class UsersService 
{
	@Autowired //Marks a constructor, field, setter method, or config method as to be autowired bySpring's dependency injection facilities.
	UsersDao udao;
	public void setUdao(UsersDao udao)
	{
		this.udao = udao;
	}
	
	@Transactional(readOnly = true) //Describes a transaction attribute on an individual method or on a class.  
	// Retrieving User details bu userId
	public Optional<Users> getUserById(int user_id)
	{
		return udao.findById(user_id);
	}
	
	@Transactional
    public String deleteUser(int userId) // User details will be deleted
    {
    	udao.deleteById(userId);
    	return "User Deleted";   
    }
	
	@Transactional
	public Users addUser(Users user) // User registration
	{
		return udao.save(user);
	}
	
	@Transactional
	public Users updateUser(Users user) // Updating user details
	{
		return udao.save(user);
	}
}