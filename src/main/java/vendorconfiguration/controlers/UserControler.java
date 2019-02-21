package vendorconfiguration.controlers;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vendorconfiguration.documents.User;
import vendorconfiguration.services.UserServices;



@RestController
@RequestMapping("/userapi")
@CrossOrigin(origins = "http://localhost:4200")
public class UserControler {
	@Autowired
	private UserServices userService;
	
	
	@PostMapping("/user/create")
	public User create(@Valid @RequestBody User user) {
		user.setUserId(UUID.randomUUID());
		return userService.create(user);
	}
	
	/*@PutMapping("/user/update/{name}")
	public String update(@PathVariable UUID userId, @RequestBody User user) {
		return userService.update(userId, user);
	}	
	@GetMapping("/user")
	public List<User> getlist() { 
		return userService.getlist();
	}
	
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable UUID userId) {
		return userService.findUser(userId);
	}
	
	@DeleteMapping(value = "/user/{name}")
	public void delete(@PathVariable UUID userId) {
		userService.deleteUser(userId);
	}*/
	
	

}
