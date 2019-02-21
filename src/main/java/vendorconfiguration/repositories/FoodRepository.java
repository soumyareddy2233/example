package vendorconfiguration.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import vendorconfiguration.documents.Food;



@Repository("foodRepo")
@CrossOrigin(origins="http://localhost:4200")
public interface FoodRepository extends MongoRepository<Food, UUID> {

	Food findBySweetId(UUID id);

}
