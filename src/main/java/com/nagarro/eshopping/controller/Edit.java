package com.nagarrro.eshopping.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.nagarro.eshopping.dao.ProductDAO;
import com.nagarro.eshopping.datafetchingutility.FetchEditFormData;
import com.nagarro.eshopping.utils.ConstantVariable;

/*
 * Edit
 * 
 * Control for Edit operation
 */

@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uploadPath = getServletContext().getRealPath("")+File.separator + ConstantVariable.UPLOAD_DIRECTORY;
		HttpSession session = request.getSession();
		
		FetchEditFormData edit = new FetchEditFormData();
		edit.fetchData(request, uploadPath);
		
		ProductDAO productdao = new ProductDAO();
		
		productdao.getProduct(session);
		
		response.sendRedirect("index.jsp");
	}
	
}
