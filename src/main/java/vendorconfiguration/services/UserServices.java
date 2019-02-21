package vendorconfiguration.services;

import java.util.List;
import java.util.UUID;

import vendorconfiguration.documents.User;



public interface UserServices {

	/*String update(UUID userId, User user);

	List<User> getlist();

	User findUser(UUID userId);

	void deleteUser(UUID userId);*/

	User create(User user);

	User findByUserEmail(String userEmail);

}
