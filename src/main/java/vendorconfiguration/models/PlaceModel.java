package vendorconfiguration.models;

import java.util.UUID;

public class PlaceModel {
	
    private UUID placeId;
	private String placeName;
	private String state;
	private String country;
	private String pincode;
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
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}	

}
