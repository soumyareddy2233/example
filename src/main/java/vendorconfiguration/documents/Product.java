package vendorconfiguration.documents;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Deploy_Products")
public class Product {

	@Id
	private UUID productId;
	private String productName;
	private String productType;
	private String availabilityLocation;
	private String productDescription;
	
	public UUID getProductId() {
		return productId;
	}
	public void setProductId(UUID productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getAvailabilityLocation() {
		return availabilityLocation;
	}
	public void setAvailabilityLocation(String availabilityLocation) {
		this.availabilityLocation = availabilityLocation;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
}
