package com.nagarro.eshopping.datafetchingutility;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.nagarro.eshopping.dao.ProductDAO;
import com.nagarro.eshopping.utils.ConstantVariable;

/*
 *FetchFromData
 *
 *To fetch data from product form 
 */


public class FetchFormData {
	
	float memorysize;
	
	int quantity,size;
	
	String image, title;
	
	
	public void fetchData(HttpServletRequest request, String uploadPath) {
		
		HttpSession session = request.getSession();
		quantity =size=0;
		title = "";
		image = ConstantVariable.DEFAULT_SYMBOL;
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = null;

		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		Iterator<FileItem> iter = items.iterator();
		
		while (iter.hasNext()) {
			
			FileItem item = iter.next();

			if (item.isFormField()) {
				if (item.getFieldName().equals("title")) {
					title = item.getString();
				}

				if (item.getFieldName().equals("quantity")) {
					quantity = Integer.parseInt(item.getString());
				}

				if (item.getFieldName().equals("size")) {
					size = Integer.parseInt(item.getString());
				}
			} 
			
			
			else {
				
				try {
					image = "images/" + processUploadedFile(item, uploadPath);
				} catch (Exception e) {
					
					//Default image will be very low in memory size
					
					memorysize = 0;
					e.printStackTrace();
				}
			}
		}
		
		ProductDAO productdao = new ProductDAO();
		
		productdao.setProduct(title, quantity, size, image,memorysize);
		
		productdao.getProduct(session);
		
		
	}

	private String processUploadedFile(FileItem item, String uploadPath) throws Exception {
		
		float sz = (float)item.getSize()/(1024*1024);
		String szStr = String.format("%.2f", sz);
		
		memorysize = Float.parseFloat(szStr);
		
		System.out.println("memory size = " + memorysize);
		
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();
		
		String fileName = new File(item.getName()).getName();
        String filePath = uploadPath + File.separator + fileName;
        System.out.println(filePath);
        File storeFile = new File(filePath);
        item.write(storeFile);
		
        return fileName;
	}
	
	
}
