package com.poscoict.fileupload.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "/upload-images";
	private static String URL_BASE = "/images";
	
	public String restore(MultipartFile multipartFile) {
		String url = null;
		
		try {
			if (multipartFile.isEmpty()) {
				return url;
			}
			
			String originFileName = multipartFile.getOriginalFilename();
			String extName = originFileName.substring(originFileName.lastIndexOf("."));
			String saveFileName = generateSaveFileName(extName);
			long fileSize = multipartFile.getSize();
			
			System.out.println("###################" + originFileName);
			System.out.println("###################" + saveFileName);
			System.out.println("###################" + fileSize);
			
			byte[] data = multipartFile.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
			os.write(data);
			os.close();
			
			url = URL_BASE + "/" + saveFileName;
			
		} catch (IOException ex ) {
			throw new RuntimeException("file upload error : " + ex);
		}

		return url;
	}


	private String generateSaveFileName(String extName) {
		String filename = "";
		
		Calendar calendar = Calendar.getInstance();
		
		filename += calendar.get(calendar.YEAR);
		filename += calendar.get(calendar.MONTH);
		filename += calendar.get(calendar.DATE);
		filename += calendar.get(calendar.HOUR);
		filename += calendar.get(calendar.MINUTE);
		filename += calendar.get(calendar.SECOND);
		filename += calendar.get(calendar.MILLISECOND);
		filename += extName;
		
		return filename;
	}

}
