package vendorconfiguration.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vendorconfiguration.documents.Food;
import vendorconfiguration.documents.Place;
import vendorconfiguration.documents.Vendor;
import vendorconfiguration.repositories.FoodRepository;
import vendorconfiguration.repositories.PlaceRepository;
import vendorconfiguration.repositories.VendorRepository;



@Service("nativeFoodService")
public class NativeFoodServiceImpl implements NativeFoodService {

	@Autowired
	private VendorRepository vendorRepo;
	
	@Autowired
	private PlaceRepository placeRepo;
	
	@Autowired
	private FoodRepository foodRepo;
	
	/*Vendor Service Implementation*/
	
	@Override
	public List<Vendor> getAllVendors() {
		return vendorRepo.findAll();
	}
	
	@Override
	public Vendor getVendorById(UUID Id) {
		return vendorRepo.findByVendorId(Id);
	}

	@Override
	public Vendor createVendor(Vendor vendor) {
		return vendorRepo.insert(vendor);
	}
	
	@Override
	public String updateVendor(UUID Id, Vendor vendor) {
		Vendor vendorData = vendorRepo.findByVendorId(Id);
		if (Id == null) {
			return "Vendor Store Not Found";
		}
		vendorData.setVendorName(vendor.getVendorName());
		vendorData.setVendorStoreName(vendor.getVendorStoreName());
		vendorData.setVendorStoreCity(vendor.getVendorStoreCity());
		vendorData.setVendorEmail(vendor.getVendorEmail());
		vendorData.setServices(vendor.getServices());
		vendorRepo.save(vendorData);
		
		return "Vendor Details Updated Successfully!";
	}


	@Override
	public String deleteOneVendor(UUID Id) {
		vendorRepo.deleteById(Id);
		return "Vendor has been Deleted!";
	}

	@Override
	public String deleteAllVendors() {
		vendorRepo.deleteAll();
		return "All Vendors have been Deleted!";
	}

	/*Place Service Implementation*/
	
	@Override
	public List<Place> getlist() {
		return placeRepo.findAll();
	}
	
	@Override
	public Place getPlaceByPlaceId(UUID data) {
		return placeRepo.findByPlaceId(data);	
	}

	@Override
	public Place createPlace(Place place) {
	return placeRepo.insert(place);
	}

	@Override
	public String update(UUID data, Place place) {
		Place placeData=placeRepo.findByPlaceId(data);
		if (data == null) {
			return "Place Not Found";
		}
		
		placeData.setPlaceName(place.getPlaceName());
		placeData.setState(place.getState());
		placeData.setCountry(place.getCountry());
		placeData.setPincode(place.getPincode());
		placeRepo.save(placeData);
		return "Place is updated";
	}

	@Override
	public String delete(UUID data) {
		placeRepo.deleteById(data);
		return "Document deleted successfully";
	}

	@Override
	public String deleteTotal() {
		placeRepo.deleteAll();
		return "All Documents are Deleted";
	}
	
	/*Food Service Implementation*/
	
	@Override
	public Food findBySweetId(UUID Id) {
		return foodRepo.findBySweetId(Id);
	}
	
	@Override
	public List<Food> getAllSweets() {
		return foodRepo.findAll();
	}

	@Override
	public Food create(Food food) {
		return foodRepo.insert(food);
	}

	@Override
	public String update(UUID Id, Food food) {
		Food foodData=foodRepo.findBySweetId(Id);
		if (Id == null) {
			return "Sweet Not Found";
		}
	
		foodData.setLocationName(food.getLocationName());
		foodData.setSweetName(food.getSweetName());
		foodRepo.save(foodData);
		return "Sweet Details are Updated Successfully";
	}

	@Override
	public String deleteSweet(UUID Id) {
		foodRepo.deleteById(Id);
		return "Sweet deleted successfully";
	}

	@Override
	public String deleteAllSweets() {
		foodRepo.deleteAll();
		return "All Sweets are Deleted";
	}

	
}