package vendorconfiguration.repositories;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import vendorconfiguration.documents.ImageModel;


@Repository("imageRepo")
public interface ImageRepo extends MongoRepository<ImageModel, UUID> {


}
