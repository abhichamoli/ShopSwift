package com.nagarro.eshopping.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.nagarro.eshopping.hibernate.HibernateUtil;
import com.nagarro.eshopping.model.Product;
import com.nagarro.eshopping.utils.ConstantVariable;

/*
 * ProductEditDAO
 * 
 * perform edit operations on database
 */

@SuppressWarnings("deprecation")
public class ProductEditDAO {
	
	@SuppressWarnings({ "rawtypes" })
	public void editItem(int serialNo, String title, int quantity, int size, String image, float memorysize) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();  
		
		Session session = factory.openSession(); 
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Product where s_no = :serialNo");
		query.setParameter("serialNo", serialNo);
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		

		
		if(title.equals(""))
			title = list.get(0).getTitle();
		
		if(quantity == 0)
			quantity = list.get(0).getQuantity();
		
		if(size == 0)
			size = list.get(0).getSize();
		
		if(image.equals(ConstantVariable.DEFAULT_SYMBOL))
			image = list.get(0).getImageurl();
		
		Query q2 =session.createQuery("update Product set title=:title, quantity=:quantity, size=:size, imageurl=:image , memorysize=:memorysize where s_no=:serialNo");
		
		q2.setParameter("title", title);
		q2.setParameter("quantity", quantity);
		q2.setParameter("size", size);
		q2.setParameter("image", image);
		q2.setParameter("memorysize", memorysize);
		q2.setParameter("serialNo", serialNo);
	
		q2.executeUpdate();  
		
		transaction.commit();
	
	}
}
