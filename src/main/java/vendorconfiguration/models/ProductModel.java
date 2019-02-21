package vendorconfiguration.models;

import java.util.UUID;

public class ProductModel {
	
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
