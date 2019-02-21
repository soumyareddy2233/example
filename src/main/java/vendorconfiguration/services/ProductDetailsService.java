package vendorconfiguration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vendorconfiguration.documents.ProductDetailsModel;
import vendorconfiguration.repositories.ProductDetailsRepository;

@Service
public class ProductDetailsService 
{
	@Autowired
	private ProductDetailsRepository productdetailsrepository;
	
	public ProductDetailsModel getFileId(String fileid)
	{
		ProductDetailsModel response = productdetailsrepository.findByfileId(fileid);
		
		return response;
	}

}
