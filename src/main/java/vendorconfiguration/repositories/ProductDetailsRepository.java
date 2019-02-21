package vendorconfiguration.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import vendorconfiguration.documents.ImageModel;
import vendorconfiguration.documents.ProductDetailsModel;

@Repository("productDetailsRepository")
public interface ProductDetailsRepository extends  MongoRepository<ProductDetailsModel, String>
{

	ProductDetailsModel findByfileId(String fileid);
	



}
