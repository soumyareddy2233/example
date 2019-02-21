package vendorconfiguration.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import vendorconfiguration.documents.Product;





@Repository("productRepo")
@CrossOrigin(origins="http://localhost:4200")
public interface ProductRepository extends MongoRepository<Product, UUID> {

	Product findByProductId(UUID Id);

}
