package com.nagarrro.eshopping.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.eshopping.dao.AdminDAO;
import com.nagarro.eshopping.dao.ProductDAO;
import com.nagarro.eshopping.model.Admin;

/*
 * Login
 * 
 * Controller for login operation
 */

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("uname");
		String password = request.getParameter("pwd");
			
		AdminDAO dao = new AdminDAO();
		Admin admin = dao.getAdmin(userName, password);
		
		ProductDAO product = new ProductDAO();
		
		HttpSession session = request.getSession();
		
		if(admin!= null) {
			product.getProduct(session);
			session.setAttribute("username", userName);
			response.sendRedirect("index.jsp");
		}else {
			session.setAttribute("username", "invalid");
			response.sendRedirect("signin.jsp");
		}
		
	}

}
