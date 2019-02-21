package vendorconfiguration.services;

import java.util.List;
import java.util.UUID;

import vendorconfiguration.documents.Food;
import vendorconfiguration.documents.Place;
import vendorconfiguration.documents.Vendor;



public interface NativeFoodService {
	
	/*Vendor Services*/
	Vendor getVendorById(UUID Id);
	List<Vendor> getAllVendors();
	Vendor createVendor(Vendor vendor);
	String updateVendor(UUID ID,Vendor vendor);
	String deleteOneVendor(UUID Id);
	String deleteAllVendors();
	
	/*Place Services*/
	Place getPlaceByPlaceId(UUID data);
	List<Place> getlist();
	Place createPlace(Place place);
	String update(UUID data, Place place);
	String delete(UUID data);
	String deleteTotal();
	
	/*Food Services*/
    Food findBySweetId(UUID Id);
	List<Food> getAllSweets();
	Food create(Food food);
	String update(UUID Id,Food food);
	String deleteSweet(UUID Id);
	String deleteAllSweets();
	
}