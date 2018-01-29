package com.jasperalani;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveProducts {
	
	public static void main (String[] args) {}
	
	public static void saveProductList(ArrayList<Product> list) {
		SaveProducts obj = new SaveProducts();
		obj.serializeProductList(list);
	}

	private void serializeProductList(ArrayList<Product> list) {
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("products.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			System.out.println("Saved product list.");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

}
