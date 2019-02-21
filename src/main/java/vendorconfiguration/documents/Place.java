package vendorconfiguration.documents;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Place_Registration")
public class Place {
	
	@Id
	private UUID placeId;
	private String placeName;
	private String state;
	private String country;
	private Integer pincode;
	public UUID getPlaceId() {
		return placeId;
	}
	public void setPlaceId(UUID placeId) {
		this.placeId = placeId;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

}