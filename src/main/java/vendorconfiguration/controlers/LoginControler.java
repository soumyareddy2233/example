package vendorconfiguration.controlers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vendorconfiguration.documents.User;
import vendorconfiguration.services.UserServices;



@RestController
@RequestMapping("/userapp")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginControler {
	
	@Autowired
	private UserServices userService; 
	
	
/*	@PostMapping("/user/create")
	public String create(@RequestBody User user) {
		user.setUserId(UUID.randomUUID());
		//if user already exist will not allow him to register again
		if(userService.findByUserEmail(user.getUserEmail())!=null) {
			return "user name already exist. please try with new username.";
		}
		return userService.create(user).toString();
	}*/
	
	
	
	
	
	
	@PostMapping("/login")
	public String userLogin(@RequestBody User user)
	{
     System.out.println("user name"+user.getUserEmail());
     
	User usr=userService.findByUserEmail(user.getUserEmail());
	System.out.println("is user valid"+usr.toString().isEmpty());
		if(usr!=null) 
		{
			System.out.println("usr password"+usr.getUserPassword());
			System.out.println("user password"+user.getUserPassword());
			System.out.println("usr role"+usr.getUserType());
			System.out.println("user role"+user.getUserType());
			
		if(usr.getUserPassword().equals(user.getUserPassword()) && usr.getUserType().equals(user.getUserType()))
		{
			//***rolels//
				return "redirect:admin"; 
		}else { 
			return "redirect:user";
		}			  
	 }
	 return "User credentials invalid";
	}
	

	
	
}
