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
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jasperalani.IMSMain;
import com.jasperalani.Product;

public class IMSGUI extends JFrame implements ActionListener {
	
	String strTitle = "Inventory Management System";
	String userName = "";
	
	IMSMain main;
	
	private JButton addProduct, outputProducts, settings;
	private JButton search;
	
	private JTextField searchTF;
	
	private static final long serialVersionUID = 1L;
	
	public IMSGUI() {
		
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
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		topPanel.add(new JLabel("Hi, " + userName + "."));
		
		addProduct = new JButton("Add Product");
		topPanel.add(addProduct);
		addProduct.addActionListener(this);
		
		outputProducts = new JButton("Output");
		topPanel.add(outputProducts);
		outputProducts.addActionListener(this);
		
		settings = new JButton("Settings");
		topPanel.add(settings);
		settings.addActionListener(this);
		
		JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		searchTF = new JTextField(50);
		searchPanel.add(searchTF);
		
		search = new JButton("Search");
		searchPanel.add(search);
		search.addActionListener(this);
		
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(searchPanel, BorderLayout.CENTER);
		
		getContentPane().add(mainPanel);

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
		}
		if (evt.getSource() == outputProducts) {
			for(int i = 0; i < IMSMain.products.size(); i++) {
				System.out.println(IMSMain.products.get(i).getProductAsString());
			}
		}
		if (evt.getSource() == settings) {
			new SettingsGUI().setVisible(true);
		}
		if (evt.getSource() == search) {
			searchProducts(searchTF.getText().toString().toLowerCase());
		}
	}
	
	public void searchProducts(String input) {
		for(Product p : IMSMain.products) {
			if(p.getName() != null && p.getName().toLowerCase().contains(input)) {
				System.out.println("Found: " + p.getProductAsString());
			}
		}
	}

}
