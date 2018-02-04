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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.jasperalani.IMSMain;
import com.jasperalani.Product;

public class IMSGUI extends JFrame implements ActionListener {
	
	String strTitle = "Inventory Management System";
	String userName = "";
	
	IMSMain main;
	
	private JButton addProduct, removeProduct, settings;
	private JButton search, X;
	
	private JTextField searchTF;
	
	public String[] columns;
	
	private JPanel mainPanel, centerPanel;
	
	private DefaultTableModel model;
	
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
		
		mainPanel = new JPanel(new BorderLayout());
		
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		topPanel.add(new JLabel("Hi, " + userName + "."));
		
		addProduct = new JButton("Add Product");
		topPanel.add(addProduct);
		addProduct.addActionListener(this);
		
		removeProduct = new JButton("Remove Product");
		topPanel.add(removeProduct);
		removeProduct.addActionListener(this);
		
		settings = new JButton("Settings");
		topPanel.add(settings);
		settings.addActionListener(this);
		
		JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		searchTF = new JTextField(25);
		searchPanel.add(searchTF);
		
		search = new JButton("Search");
		search.addActionListener(this);
		searchPanel.add(search);
		
		X = new JButton("X");
		X.addActionListener(this);
		if(IMSMain.searched) { searchPanel.add(X); }

		columns = new String[] {
	            "Name", "Quantity", "Price", "ID", "Category"
	        };
		
		model = new DefaultTableModel(columns, 0);
		JTable table = new JTable(model);
        
        Object[] row = new Object[5];
        
        if (!IMSMain.searched) {
        	
        	for(int i = 0; i < IMSMain.products.size(); i++) {
        		for(int j = 0; j < 5; j++) {
            		row[j] = IMSMain.products.get(i).getItemAtPos(j);
            	}
        		model.addRow(row);
        	}
        	
        } else {
        	
        	for(int i = 0; i < 5; i++) {
        		row[i] = IMSMain.dataSearch[0][i];
        	}
        	
        	model.addRow(row);
        }
        
        centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        centerPanel.add(searchPanel, BorderLayout.NORTH);
        centerPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		
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
			this.setVisible(false);
		}
		if (evt.getSource() == removeProduct) {
			new RemoveProductGUI().setVisible(true);
			this.setVisible(false);
		}
		if (evt.getSource() == settings) {
			new SettingsGUI().setVisible(true);
		}
		if (evt.getSource() == search) {
			searchProducts(searchTF.getText().toString().toLowerCase());
		}
		if (evt.getSource() == X) {
			if(IMSMain.searched) {
				IMSMain.searched = false;
				this.setVisible(false);
				new IMSGUI();
			}
		}
	}
	
	public void searchProducts(String input) {
		if(!input.equals("")) {
			for(Product p : IMSMain.products) {
				if(p.getName() != null && p.getName().toLowerCase().contains(input)) {
					IMSMain.dataSearch = new Object[1][5];
					for(int i = 0; i < 5; i++) {
						IMSMain.dataSearch[0][i] = p.getItemAtPos(i);
					}
				}
			}
			IMSMain.searched = true;
			this.setVisible(false);
			new IMSGUI();
		}
	}

}
