package com.nagarrro.eshopping.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.nagarro.eshopping.dao.DeleteDAO;
import com.nagarro.eshopping.dao.ProductDAO;

/*
 *DelteItem 
 * 
 *Controller class for delete operation
 */

@WebServlet("/DeleteItem")
public class DeleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int serialNo = Integer.parseInt(request.getParameter("sno")); 
		
		DeleteDAO delete = new DeleteDAO();
		
		delete.deleteItem(serialNo);
		
		HttpSession hsession = request.getSession();
		
		ProductDAO product = new ProductDAO();
		
		product.getProduct(hsession);
		
		response.sendRedirect("index.jsp");
	}

}
