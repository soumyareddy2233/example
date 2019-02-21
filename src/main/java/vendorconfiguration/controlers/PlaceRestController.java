package vendorconfiguration.controlers;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vendorconfiguration.documents.Place;
import vendorconfiguration.services.NativeFoodService;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class PlaceRestController {
	
	@Autowired
	private NativeFoodService nativeFoodService;
	
	@GetMapping("/places")
	public List<Place> getlist()
	{	
		return nativeFoodService.getlist();
	}
	
    @PostMapping(value="/places/create")
	public Place createPlace(@Valid @RequestBody Place place)
	{
    	 place.setPlaceId(UUID.randomUUID());
		return nativeFoodService.createPlace(place);
	}
	   
    @GetMapping("/places/{placeId}")
    public Place getOnePlace(@PathVariable String placeId)
    {
    	UUID data=UUID.fromString(placeId);
    	return nativeFoodService.getPlaceByPlaceId(data);
    	
    }

    @RequestMapping(value="/places/{placeId}",method = RequestMethod.PUT)  
	public String update(@PathVariable String placeId, @RequestBody Place place) 
    {
		 UUID data=UUID.fromString(placeId);
		 nativeFoodService.update(data, place);
	     return "Data Updated Successfully";
	}
    
	@DeleteMapping(value = "places/{placeId}") 
	public String delete(@PathVariable String placeId) 
	{
		 UUID data=UUID.fromString(placeId);
		 nativeFoodService.delete(data);
	     return "Data Deleted Successfully";
	}
	
	@DeleteMapping("/places/deleteAll")
	public String deleteAll()
	{
		nativeFoodService.deleteTotal();
		return "All Data have been deleted!";
	}

}