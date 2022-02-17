package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class imageUtil {
	private static final Logger logger = (Logger) Logger
	.getLogger(imageUtil.class);

	public static void viewDoc(HttpServletResponse response, HashMap hashmap) {
		logger.info("TaskPageUtil: viewDoc---->");
		try {			
			File file = (File) hashmap.get("file");
			String mimeType = (String)hashmap.get("mimeType");
			String headerInfo = (String)hashmap.get("header_info");
			String mimeTypeName = (String)hashmap.get("mimeTypeName");
			FileInputStream fis = null;
			ServletOutputStream outstream = null;
			BigDecimal bigDeciLength = new BigDecimal(file.length());
			int fileLength = bigDeciLength.intValue();
			logger.debug("The file length is :::"+fileLength);
			try {			
				if (!"text/x- whatever".equals(mimeType)) {
					response.setContentLength(fileLength);
					if (headerInfo.indexOf("MSIE") != -1) {
						if ((mimeType == "text/x-whatever")	|| ("text/x-whatever".equals(mimeType))) {
							response.setContentType(mimeType);
						} else {
							response.setContentType(mimeTypeName);
						}
					} else {						
						response.setContentType("application/x-filler");						
					}
					fis = new FileInputStream(file);
					outstream = response.getOutputStream();					
						byte[] buf = new byte[8 * 1024]; // 4K buffer
						int bytesRead;	
						while ((bytesRead = fis.read(buf)) != -1) {
							outstream.write(buf, 0, bytesRead);
						}									
				} else {
					response.setContentLength(fileLength);					
					response.setContentType(mimeTypeName);					
					fis = new FileInputStream(file);
					outstream = response.getOutputStream();					
						byte[] buf = new byte[8 * 1024]; // 4K buffer
						int bytesRead;	
						while ((bytesRead = fis.read(buf)) != -1) {
							outstream.write(buf, 0, bytesRead);
						}				
					file.delete();
				}
			} catch (Exception e) {
				logger.error("error occured in ViewDocument ", e);
				
			} finally {
				if (fis != null) {
					fis.close();
				}
				if (outstream != null) {
					outstream.close();
				}
			}			
		} catch (Exception e) {
			logger.error("error occured in ViewDocument ", e);
		
		}
		logger.info("imageUtil: viewDoc<----");
	}
}
