package vendorconfiguration.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import vendorconfiguration.documents.Image;


@Repository("multiRepo")
public interface MultiRepo extends MongoRepository<Image, UUID>{

	//Image findImageById(UUID iD);

}
