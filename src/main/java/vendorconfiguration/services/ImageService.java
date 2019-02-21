package vendorconfiguration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import vendorconfiguration.documents.Image;
import vendorconfiguration.documents.ImageModel;
import vendorconfiguration.repositories.ImageRepo;
import vendorconfiguration.repositories.MultiRepo;


@Service
public class ImageService {
	MongoTemplate mongoTemplate;

	@Autowired
	private MultiRepo multiRepo;
	
	public void insertPath(Image image) {
		multiRepo.insert(image);	
	}
	
	@Autowired
	private ImageRepo imageRepo;
	public void insert(ImageModel imageModel) {
		imageRepo.insert(imageModel);
	}
	public List<ImageModel> getAll() {
		
		 return imageRepo.findAll();
		
		}
	
	}
