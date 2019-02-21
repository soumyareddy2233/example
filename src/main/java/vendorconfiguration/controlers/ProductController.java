package vendorconfiguration.controlers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import vendorconfiguration.documents.Product;
import vendorconfiguration.services.ProductService;




@RestController
@RequestMapping("/productapi")
@CrossOrigin(origins="http://localhost:4200")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAllProducts() { 
		return productService.getAllProducts();
	}
	
	@GetMapping("/products/{productId}")
	public Product getOneProduct(@PathVariable String productId) {
		UUID Id=UUID.fromString(productId);
		return productService.getProductById(Id);
	} 

	@PostMapping("/products/create")
	public Product deployProduct(@Valid @RequestBody Product product) {
		product.setProductId(UUID.randomUUID());
		return productService.insertProduct(product);
	}
	
	@RequestMapping(value="/products/{productId}", method=RequestMethod.PUT)
	public String updateProduct(@PathVariable String productId, @RequestBody Product product) { 
		UUID Id=UUID.fromString(productId);
		productService.updateProduct(Id, product);
		return "Product Details Updated Successfully!";
	}
 
	@DeleteMapping("/products/{productId}")
	public String deleteProduct(@PathVariable String productId) {
		UUID Id=UUID.fromString(productId);
		productService.deleteOneProduct(Id);
		return "Product has been deleted!";
	}
	
	@DeleteMapping("/products/delete")
	public String deleteAllProducts() {
		productService.deleteAllProducts();	
		return "All Products have been deleted!";
	}
	
	List<String> files = new ArrayList<String>();

	@PostMapping("/post")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			productService.store(file);
			files.add(file.getOriginalFilename());

			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}

	@GetMapping("/getallfiles")
	public ResponseEntity<List<String>> getListFiles(Model model) {
		List<String> fileNames = files
				.stream().map(fileName -> MvcUriComponentsBuilder
						.fromMethodName(ProductController.class, "getFile", fileName).build().toString())
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(fileNames);
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = productService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
}
