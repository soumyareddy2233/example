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

import vendorconfiguration.documents.Food;
import vendorconfiguration.services.NativeFoodService;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class FoodController {
	
	@Autowired	
	private NativeFoodService nativeFoodService; 

	@PostMapping("/sweets/create")
	public Food createSweet(@Valid @RequestBody Food food) 
	{
		food.setSweetId(UUID.randomUUID());
		return nativeFoodService.create(food);
	}
	
	@GetMapping("/sweets/{sweetId}")
	public Food getOneSweet(@PathVariable String sweetId) {
		UUID Id=UUID.fromString(sweetId);
		return nativeFoodService.findBySweetId(Id);
	}
	
	@GetMapping("/sweets")
	public List<Food> getAllFoods() { 
		return nativeFoodService.getAllSweets();
	}
	
	@RequestMapping(value="/sweets/{sweetId}", method=RequestMethod.PUT)
	public String updatesweet(@PathVariable String sweetId, @RequestBody Food food) 
	{ 
		UUID Id=UUID.fromString(sweetId);
		nativeFoodService.update(Id, food);
		return "food Details Updated Successfully!";
	}

	@DeleteMapping("/sweets/{sweetId}")
	public String deletesweet(@PathVariable String sweetId) 
	{
		UUID Id=UUID.fromString(sweetId);
		nativeFoodService.deleteSweet(Id);
		return "Sweet has been deleted!";
	}
	
	@DeleteMapping("/sweets/delete")
	public String deleteAllFoods() {
		nativeFoodService.deleteAllSweets();	
		return "All Vendors have been deleted!";
	}	

}