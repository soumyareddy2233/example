package vendorconfiguration.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vendorconfiguration.documents.User;
import vendorconfiguration.repositories.UserRepositories;



@Service("userService")
public class UserServiceImpl implements UserServices {
	
	@Autowired
	private UserRepositories userrepositories;

	@Override
	public User create(User user) {
		
		return userrepositories.insert(user);
	}

	@Override
	public User findByUserEmail(String userEmail) {
		return userrepositories.findByUserEmail(userEmail);
	}

	

}
