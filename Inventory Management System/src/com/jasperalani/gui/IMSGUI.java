package com.jasperalani.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jasperalani.IMSMain;

public class IMSGUI extends JFrame implements ActionListener {
	
	String strTitle = "Inventory Management System";
	String userName = "";
	
	IMSMain main;
	
	private JButton addProduct, outputProducts, settings;
	
	private static final long serialVersionUID = 1L;
	
	public IMSGUI() {
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		main = new IMSMain();
		
		// Update Userdata
		try {
			InputStream is = new FileInputStream("userdata.txt");
			BufferedReader buf = new BufferedReader(new InputStreamReader(is));
			userName = buf.readLine();
			buf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		add(new JLabel("Hi, " + userName + "."));
		
		addProduct = new JButton("Add Product");
		add(addProduct);
		addProduct.addActionListener(this);
		
		outputProducts = new JButton("Output");
		add(outputProducts);
		outputProducts.addActionListener(this);
		
		settings = new JButton("Settings");
		add(settings);
		settings.addActionListener(this);
		

		setResizable(false);
		setSize(600, 600);
		setTitle(strTitle);
		setLocationRelativeTo(null);
		
		setVisible(true);
			
	}
	
	public static void main(String[] args) {
		new IMSGUI();
	}
	
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == addProduct) {
			new AddProductGUI().setVisible(true);
		} else if (evt.getSource() == outputProducts) {
			for(int i = 0; i < IMSMain.products.size(); i++) {
				System.out.println(IMSMain.products.get(i).getProductAsString());
			}
		} else if (evt.getSource() == settings) {
			new SettingsGUI().setVisible(true);
		}
	}

}
