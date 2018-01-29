package com.jasperalani.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import com.jasperalani.IMSMain;
import com.jasperalani.Product;

public class AddProductGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	JTextField nameTF;
	JFormattedTextField quantityTF;
	JFormattedTextField priceTF;
	JFormattedTextField idTF;
	JTextField categoryTF;

	public AddProductGUI () {
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		// Name
		add(new JLabel("Name:"));
		nameTF = new JTextField(12);
		add(nameTF);
		
		// Quantity
		add(new JLabel("Quantity:"));
		NumberFormat formatQuan = NumberFormat.getInstance();
	    NumberFormatter ft = new NumberFormatter(formatQuan);
	    ft.setValueClass(Integer.class);
	    ft.setMinimum(0);
	    ft.setMaximum(Integer.MAX_VALUE);
	    ft.setAllowsInvalid(false);
	    ft.setCommitsOnValidEdit(true);
	    quantityTF = new JFormattedTextField(ft);
	    quantityTF.setPreferredSize(new Dimension(122, 20));
	    add(quantityTF);
	    
	    // Price
	    //TODO: Change price value class
	    add(new JLabel("Price:"));
	    NumberFormat formatPrice = NumberFormat.getInstance();
	    NumberFormatter ft1 = new NumberFormatter(formatPrice);
	    ft1.setValueClass(Integer.class);
	    ft1.setMinimum(0);
	    ft.setMaximum(Integer.MAX_VALUE);
	    ft1.setAllowsInvalid(false);
	    ft1.setCommitsOnValidEdit(true);
	    priceTF = new JFormattedTextField(ft1);
	    priceTF.setPreferredSize(new Dimension(150, 20));
	    add(priceTF);
	    
	    // ID
	    add(new JLabel("ID:"));
	    NumberFormat formatID = NumberFormat.getInstance();
	    NumberFormatter ft2 = new NumberFormatter(formatID);
	    ft2.setValueClass(Integer.class);
	    ft2.setMinimum(0);
	    ft2.setMaximum(Integer.MAX_VALUE);
	    ft2.setAllowsInvalid(false);
	    ft2.setCommitsOnValidEdit(true);
	    idTF = new JFormattedTextField(ft1);
	    idTF.setPreferredSize(new Dimension(150, 20));
	    add(idTF);
	    
	    // Category
	 	add(new JLabel("Category:"));
	 	categoryTF = new JTextField(12);
	 	add(categoryTF);
	 	
	 	JButton btnAdd = new JButton("Add");
	 	add(btnAdd);
	 	btnAdd.addActionListener(this);
		
		setSize(230, 300);
		setResizable(false);
		setTitle("Add Product");
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		
		setVisible(true);
		
	}
	
	public static void main (String[] args) {}
	
	public void actionPerformed (ActionEvent e) {
		IMSMain.products.add(new Product(nameTF.getText().toString(), Integer.valueOf(quantityTF.getText().toString()), Long.valueOf(priceTF.getText().toString()), Integer.valueOf(idTF.getText().toString()), categoryTF.getText().toString()));
		IMSMain.saveProducts();
		this.setVisible(false);
	}

}
