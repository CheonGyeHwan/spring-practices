package com.poscoict.fileupload.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "/upload-images";
	
	
	public String restore(MultipartFile multipartFile) {
		String url = null;
		
		try {
			if (multipartFile.isEmpty()) {
				return url;
			}
			
			String originalFileName = multipartFile.getOriginalFilename();
			long fileSize = multipartFile.getSize();
			
			System.out.println("###################" + originalFileName);
			System.out.println("###################" + fileSize);
			
			byte[] data = multipartFile.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "");
			
		} catch (IOException ex ) {
			throw new RuntimeException("file upload error : " + ex);
		}
		
		
		return url;
	}

}
