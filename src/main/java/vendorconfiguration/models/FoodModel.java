package vendorconfiguration.models;

import java.util.UUID;

public class FoodModel {

private UUID sweetId;
private String locationName;
private String sweetName;
public UUID getSweetId() {
	return sweetId;
}
public void setSweetId(UUID sweetId) {
	this.sweetId = sweetId;
}
public String getLocationName() {
	return locationName;
}
public void setLocationName(String locationName) {
	this.locationName = locationName;
}
public String getSweetName() {
	return sweetName;
}
public void setSweetName(String sweetName) {
	this.sweetName = sweetName;
}


}
