package vendorconfiguration.services;

import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import vendorconfiguration.documents.Product;





public interface ProductService {
	
	Product getProductById(UUID Id);
	List<Product> getAllProducts();
	Product insertProduct(Product product);
	String updateProduct(UUID ID,Product product);
	String deleteOneProduct(UUID Id);
	String deleteAllProducts();
	void store(MultipartFile file);
	Resource loadFile(String filename);
	void init();

}
