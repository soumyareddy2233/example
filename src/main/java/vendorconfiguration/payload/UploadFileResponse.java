package vendorconfiguration.payload;

import java.util.UUID;

public class UploadFileResponse {
	private UUID imageId;
	 private String fileName;
	 private String fileId;
	    private String fileDownloadUri;
	    private String fileType;
	    private long size;

		

		public UploadFileResponse(UUID imageId, String fileName, String fileId, String fileDownloadUri, String fileType,
				long size) {
			super();
			this.imageId = imageId;
			this.fileName = fileName;
			this.fileId = fileId;
			this.fileDownloadUri = fileDownloadUri;
			this.fileType = fileType;
			this.size = size;
		}



		public UUID getImageId() {
			return imageId;
		}



		public void setImageId(UUID imageId) {
			this.imageId = imageId;
		}



		public String getFileName() {
			return fileName;
		}



		public void setFileName(String fileName) {
			this.fileName = fileName;
		}



		public String getFileId() {
			return fileId;
		}



		public void setFileId(String fileId) {
			this.fileId = fileId;
		}



		public String getFileDownloadUri() {
			return fileDownloadUri;
		}



		public void setFileDownloadUri(String fileDownloadUri) {
			this.fileDownloadUri = fileDownloadUri;
		}



		public String getFileType() {
			return fileType;
		}



		public void setFileType(String fileType) {
			this.fileType = fileType;
		}



		public long getSize() {
			return size;
		}



		public void setSize(long size) {
			this.size = size;
		}

		

	

	
}


