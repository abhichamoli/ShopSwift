package com.nagarro.eshopping.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagarro.eshopping.hibernate.HibernateUtil;

/*
 * DeleteDAO
 * 
 * used to delete user data from database
 */

@SuppressWarnings("deprecation")
public class DeleteDAO {
	
	public void deleteItem(int serialNo) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();  
		
		Session session = factory.openSession();  
		
		Transaction transaction = session.beginTransaction();
		
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("delete from Product where s_no = :SNO");
		
		query.setParameter("SNO", serialNo);
		
		query.executeUpdate();
		
		transaction.commit();
		
	}
}
