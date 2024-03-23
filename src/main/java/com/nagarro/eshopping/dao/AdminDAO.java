package com.nagarro.eshopping.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.nagarro.eshopping.hibernate.HibernateUtil;
import com.nagarro.eshopping.model.Admin;

/*
 * AdminDAO class
 * 
 * used to fetch user details from database
 */

@SuppressWarnings("deprecation")
public class AdminDAO {
	
	public Admin getAdmin(String name, String password) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session = factory.openSession();  
		Transaction transaction = session.beginTransaction();
		
		Admin admin1 = new Admin();
		
		admin1.setUsername(name);
		admin1.setPassword(password);
			
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from Admin where username = :uname and password = :pwd");
		
		query.setParameter("uname", name);
		query.setParameter("pwd", password);	
		
		@SuppressWarnings("unchecked")
		List<Admin> list = query.list();
		
		transaction.commit();
		//return admin1;
		if(list.size()!=0)
			return list.get(0);
		else
			return null;
		
		
		
	}
		
}
