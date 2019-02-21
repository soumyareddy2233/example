package vendorconfiguration.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vendorconfiguration.documents.Product;
import vendorconfiguration.repositories.ProductRepository;





@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("C:\\images");	

	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public Product insertProduct(Product product) {
		return productRepo.insert(product);
	}

	@Override
	public Product getProductById(UUID Id) {
		return productRepo.findByProductId(Id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}
	
	@Override
	public String updateProduct(UUID ID, Product product) {
		Product productData = productRepo.findByProductId(ID);
		if (ID == null) {
			return "Product Not Found";
		}
		productData.setProductName(product.getProductName());
		productData.setProductType(product.getProductType());
		productData.setAvailabilityLocation(product.getAvailabilityLocation());
		productData.setProductDescription(product.getProductDescription());
		productRepo.save(productData);
		
		return "Product Details Updated Successfully!";
	}

	@Override
	public String deleteOneProduct(UUID Id) {
		productRepo.deleteById(Id);
		return "Product has been Deleted!";
	}

	@Override
	public String deleteAllProducts() {
		productRepo.deleteAll();
		return "All Products have been Deleted!";
	}

	@Override
	public void store(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}		
	}

	@Override
	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}

	@Override
	public void init() {
		File directory=new File(rootLocation.toString());
		if(directory.exists()== false) {
			try {
				Files.createDirectory(rootLocation);
			}
			catch (IOException e) {
				throw new RuntimeException("Could not initialize storage!");
			}
			}
			else {
				System.out.println("Folder Already Exists!");
			}		
	}

	
	
}
