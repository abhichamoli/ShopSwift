package com.nagarro.eshopping.datafetchingutility;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.nagarro.eshopping.dao.ProductEditDAO;
import com.nagarro.eshopping.utils.ConstantVariable;

/*
 *FetchEditFromData 
 * 
 * utility class to fetch edit data
 */

public class FetchEditFormData {
	
	float memorysize;
	
	int quantity,size,sno;
	
	String image, title;
	
	
	public void fetchData(HttpServletRequest request, String uploadPath) {
		
		quantity = size = sno = 0;
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
				
				if(item.getFieldName().equals("sno"))
		         {   
		    		 sno= Integer.parseInt(item.getString());
		         }
	
				if (item.getFieldName().equals("title")) {
					
					if(!item.getString().equals(""))
					title = item.getString();
				}

				if (item.getFieldName().equals("quantity")) {
					
					if(!item.getString().equals(""))
					quantity = Integer.parseInt(item.getString());
				}

				if (item.getFieldName().equals("size")) {
					
					if(!item.getString().equals(""))
					size = Integer.parseInt(item.getString());
				}
			} 
			
			
			else {
				
				try {
					image = "images/" + processUploadedFile(item, uploadPath);
				} catch (Exception e) {
					
					// default image is very low in memorysize
					
					memorysize = 0;
					e.printStackTrace();
				}
			}
		}
		
		ProductEditDAO productEdit = new ProductEditDAO();
		
		productEdit.editItem(sno, title, quantity, size, image, memorysize);
		
	}

	
	private String processUploadedFile(FileItem item, String uploadPath) throws Exception {
		
		float sz = (float)item.getSize()/(1024*1024);
		String szStr = String.format("%.2f", sz);
		
		memorysize = Float.parseFloat(szStr);
		
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
