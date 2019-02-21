/**
 * 
 */
package vendorconfiguration.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import vendorconfiguration.documents.Place;
@Repository("placeRepo")
@CrossOrigin(origins="http://localhost:4200")
public interface PlaceRepository extends MongoRepository<Place, UUID> {

	Place findByPlaceId(UUID data);

}
