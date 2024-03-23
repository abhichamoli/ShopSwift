package com.nagarro.eshopping.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.nagarro.eshopping.hibernate.HibernateUtil;
import com.nagarro.eshopping.model.Product;

/*
 * ProductDAO
 * 
 * User set and get product from database
 */


@SuppressWarnings("deprecation")
public class ProductDAO {
	
	public void setProduct(String Title, int quantity, int size, String imageurl, float memorysize) {
		
		Product product = new Product();
		
		product.setTitle(Title);
		product.setQuantity(quantity);
		product.setSize(size);
		product.setImageurl(imageurl);
		product.setMemorysize(memorysize);
 		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session = factory.openSession();  
		Transaction transaction = session.beginTransaction();
		
		session.save(product);
		
		transaction.commit();
	
	
	}
	
	public void getProduct(HttpSession hsession) {
		
		float memorysize = 0;
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		
		Session session = factory.openSession(); 
		
		Transaction transaction = session.beginTransaction();
		
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from Product");
		
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		
		int count = 0;
		for(Product item: list) {
			count += 1;
			memorysize += item.getMemorysize();
		}
		
		String totalMemorysize = String.format("%.2f", memorysize);
		
		hsession.setAttribute("plist", list);
		
		hsession.setAttribute("totalsize", totalMemorysize);
		
		hsession.setAttribute("totalitems", count);
		
		transaction.commit();
	}
}





