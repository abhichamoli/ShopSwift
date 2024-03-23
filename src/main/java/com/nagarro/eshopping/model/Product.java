package com.nagarro.eshopping.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Product  
 * 
 * Model class for product
 */

@Entity
public class Product {
	
	@Id
	private int s_no;
	private String title;
	private int quantity;
	private int size;
	private String imageurl;
	private float memorysize;

	
	public float getMemorysize() {
		return memorysize;
	}
	public void setMemorysize(float memorysize) {
		this.memorysize = memorysize;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	
}
