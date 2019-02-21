package vendorconfiguration.services;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import vendorconfiguration.exception.FileStorageException;
import vendorconfiguration.exception.MyFileNotFoundException;
import vendorconfiguration.property.FileStorageProperties;
import vendorconfiguration.repositories.ImageRepo;

//import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.Normalizer;
import java.util.stream.Stream;




@Service
public class FileStorageService {

	private final Path fileStorageLocation;
	@Autowired
	private ImageRepo imagerepo;
	
	
    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String storeFile(MultipartFile file ,String fileid) {
        // Normalize file name
        //String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    	System.out.println("Testing File Name *****"+fileid);
        try {
            // Check if the file's name contains invalid characters
            if(fileid.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileid);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileid);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileid;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileid + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
      
    }
    
    public Resource loadFileAsFileId(String fileId) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileId).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) 
            {
                return resource;
            } else 
            {
                throw new MyFileNotFoundException("File not found " + fileId);
            }
        } catch (MalformedURLException ex) 
        {
            throw new MyFileNotFoundException("File not found " + fileId, ex);
        }
      
    }
 
   
    public Stream<Path> loadFiles() {
        try {
            return Files.walk(this.fileStorageLocation, 1)
                .filter(path -> !path.equals(this.fileStorageLocation))
                .map(this.fileStorageLocation::relativize);
        }
        catch (IOException e) {
        	throw new RuntimeException("\"Failed to read stored file");
        }
	}


	
}
