package vendorconfiguration.documents;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Vendor_Registration")
public class Vendor {
	@Id
	private UUID vendorId;
	private String vendorName;
	private String vendorStoreName;
	private String vendorStoreCity;
	private String vendorEmail;
	private List<String> services;
	public UUID getVendorId() {
		return vendorId;
	}
	public void setVendorId(UUID vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorStoreName() {
		return vendorStoreName;
	}
	public void setVendorStoreName(String vendorStoreName) {
		this.vendorStoreName = vendorStoreName;
	}
	public String getVendorStoreCity() {
		return vendorStoreCity;
	}
	public void setVendorStoreCity(String vendorStoreCity) {
		this.vendorStoreCity = vendorStoreCity;
	}
	public String getVendorEmail() {
		return vendorEmail;
	}
	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}
	public List<String> getServices() {
		return services;
	}
	public void setServices(List<String> services) {
		this.services = services;
	}
	
}