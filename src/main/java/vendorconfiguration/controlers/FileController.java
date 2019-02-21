package vendorconfiguration.controlers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import vendorconfiguration.documents.ImageModel;
import vendorconfiguration.documents.ProductDetailsModel;
import vendorconfiguration.payload.UploadFileResponse;
import vendorconfiguration.property.FileStorageProperties;
import vendorconfiguration.repositories.ImageRepo;
import vendorconfiguration.services.FileStorageService;
import vendorconfiguration.services.ImageService;
import vendorconfiguration.services.ProductDetailsService;

@RestController
@RequestMapping("/productapi")
//@CrossOrigin(origins="http://localhost:4200")

public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@Autowired
	private FileStorageService fileStorageService;
	@Autowired
	private ImageService imgserv;
	@Autowired
	FileStorageProperties fileStorageProperties;
	@Autowired
	private ImageRepo imagerepo;
	@Autowired
	private ProductDetailsService productdetailsservice;

	@PostMapping("/uploadFile")
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file)
	{

		String Fileid = UUID.randomUUID().toString();
		String fileName = fileStorageService.storeFile(file, Fileid);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();
		UploadFileResponse uprespond = new UploadFileResponse(UUID.randomUUID(), fileName, Fileid, fileDownloadUri,
				file.getContentType(), file.getSize());
		String imagePath = fileStorageProperties.getUploadDir() + File.separator + fileName;
		ImageModel imageModel = new ImageModel();
		imageModel.setImagePath(imagePath);
		imageModel.setImageId(uprespond.getImageId());
		imageModel.setImageName(uprespond.getFileName());
		imageModel.setFileId(uprespond.getFileId());
		imageModel.setImageUrl(uprespond.getFileDownloadUri());
		imgserv.insert(imageModel);
		return uprespond;
	} 

	@PostMapping("/uploadMultipleFiles")
	public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("file") MultipartFile[] files) {
		return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
	}

	@GetMapping("/downloadFile")
	public ResponseEntity<Resource> downloadFile(@RequestParam String fileName, HttpServletRequest request) {

		Resource resource = fileStorageService.loadFileAsResource(fileName);

		String contentType = null;
		try 
		{
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} 
		catch (IOException ex) 
		{
			logger.info("Could not determine file type.");
		}

		if (contentType == null)
		{
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);

	}

	@GetMapping("/downloadOneFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadOneFile(@PathVariable String fileName, HttpServletRequest request) {

		Resource resource = fileStorageService.loadFileAsResource(fileName);

		String contentType = null;
		try 
		{
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} 
		catch (IOException ex) 
		{
			logger.info("Could not determine file type.");
		}

		if (contentType == null) 
		{
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	@GetMapping("/downloadOneFileId/{fileId}")
	public ResponseEntity<Resource> downloadOneFileId(@PathVariable String fileId, HttpServletRequest request) {

		Resource resource = fileStorageService.loadFileAsFileId(fileId);

		String contentType = null;

		if (contentType == null) 
		{
			contentType = "application/octet-stream";
		}
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	@GetMapping("/getData")
	public List<ImageModel> getData() {
		return imgserv.getAll();
	}

	@GetMapping("/getData/{fileidbyone}")
	public void getFiled(@PathVariable String fileidbyone) 
	{
		ProductDetailsModel resp = productdetailsservice.getFileId(fileidbyone);
		if (resp == null) 
		{
			System.out.println("fileid" + resp.getFileId());
		} 
		else {
			System.out.println("fileid" + resp.getFileId());
			System.out.println("imageName" + resp.getImageName());
		}
	}

}
