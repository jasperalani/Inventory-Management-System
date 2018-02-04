package com.jasperalani;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class IMSMain {
	
	public static ArrayList<Product> products;
	
	//TODO: Remove
	public static boolean searched = false;
	public static Object[][] dataSearch;
	
	public IMSMain() {
		
		products = new ArrayList<Product>();
		
		getProductsList();
		
	}
	
	public static void main(String[] args) {}
	
	public void getProductsList(){
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("products.ser");
			ois = new ObjectInputStream(fis);
			
			@SuppressWarnings("unchecked")
			ArrayList<Product> read = (ArrayList<Product>) ois.readObject();
			products.addAll(read);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void saveProducts() {
		
		SaveProducts.saveProductList(products);
		
	}

}
