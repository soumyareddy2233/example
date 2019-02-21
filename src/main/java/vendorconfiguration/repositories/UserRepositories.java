package vendorconfiguration.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import vendorconfiguration.documents.User;



@Repository("userrepositories")
@CrossOrigin(origins="http://localhost:4200")
public interface UserRepositories extends MongoRepository<User, UUID> {

	User findByUserEmail(String userEmail);

	

}
