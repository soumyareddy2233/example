package vendorconfiguration.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import vendorconfiguration.documents.Vendor;


@Repository("vendorRepo")
@CrossOrigin(origins="http://localhost:4200")
public interface VendorRepository extends MongoRepository<Vendor, UUID>{

	Vendor findByVendorId(UUID id);


}
