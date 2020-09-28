package com.cg.hcm.controller;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.hcm.dto.Users;
import com.cg.hcm.service.UsersService;
@RestController // Combination of @Controller and @ResponseBody
public class UsersController 
{
	@Autowired //Marks a constructor, field, setter method, or config method as to be autowired bySpring's dependency injection facilities
	UsersService usersService;
	public void setUserService(UsersService usersService)
	{
		this.usersService = usersService;
	}
	
	@GetMapping(value="/getUser/{userId}", produces="application/json") //specifying representations a resource can produce and send back to client
	public ResponseEntity<Optional<Users>> getUserDetails(@PathVariable int userId)
	{
		Optional<Users> users = usersService.getUserById(userId);
		if(users.isPresent())
			return new ResponseEntity<Optional<Users>>(users,HttpStatus.OK);
		return new ResponseEntity<Optional<Users>>(users,HttpStatus.NOT_FOUND);
	}
	@GetMapping("/login/{user_id}/{password}")
	public ResponseEntity<Optional<Users>> checkUser(@PathVariable int userId,@PathVariable String password)
	{
		System.out.println(" "+userId+" "+password);
		Optional<Users> user = usersService.getUserById(userId);
		try
		{
			if(user!=null && user.get().getPassword().equals(password))
				return new ResponseEntity<Optional<Users>>(user,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Optional<Users>>(user,HttpStatus.NOT_FOUND);
		}
		return null;
	}
	
	@DeleteMapping("/deleteUser/{userId}") //mapping HTTP DELETE requests onto deleteUser
	public ResponseEntity<String> deleteUser(@PathVariable int userId) //bounding method parameter to this URL Template
	{
		try
		{
			usersService.deleteUser(userId);
			return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>("Deletion Failed",HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/register", consumes = "application/json") //it takes json file as the reference and consumes is for representing MIME media type or representations a resource can accept or consume
	//handling the HTTP POST requests matched with above URL 
	public ResponseEntity<String> registerUser(@RequestBody Users user) //binding HTTPRequest Body to Domain Object
	{
		try 
		{
			String message="Registered Successfully";
			if(usersService.getUserById(user.getUserId()).isPresent())
			{
				message="Registration Failed";
				return new ResponseEntity<String>("Registration Failed",HttpStatus.BAD_REQUEST);
			}
			else
				if(usersService.addUser(user)==null || user.getPassword().isEmpty())
				{
					message="Registration Failed";
					return new ResponseEntity<String>("Registration Failed",HttpStatus.BAD_REQUEST);
				}
			else
				return new ResponseEntity<String>(message,HttpStatus.CREATED);	
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>("Registration Failed",HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping(value="/update",consumes="application/json")
	public ResponseEntity<String> updateUser(@RequestBody Users user)
	{
		try
		{
			usersService.updateUser(user);
			String message="Updated Successfully";
			if(user.getPassword().isEmpty() || user.getEmailId().isEmpty() || user.getUserName().isEmpty() || user.getGender().isEmpty())
			{
				message="Update failed";
				return new ResponseEntity<String>("Update Failed",HttpStatus.BAD_REQUEST);
			}
			else
				return new ResponseEntity<String>(message,HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>("Update Failed",HttpStatus.BAD_REQUEST);
		}
	}
}