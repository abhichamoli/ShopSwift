package com.nagarrro.eshopping.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nagarro.eshopping.datafetchingutility.FetchFormData;
import com.nagarro.eshopping.utils.ConstantVariable;

/*
 * Product 
 * 
 * Controller for editing product
 */

@WebServlet("/Product")
@MultipartConfig
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uploadPath = getServletContext().getRealPath("")+File.separator + ConstantVariable.UPLOAD_DIRECTORY;
		FetchFormData fetch = new FetchFormData();
		fetch.fetchData(request, uploadPath);
		
		response.sendRedirect("index.jsp");
	}
	
}
