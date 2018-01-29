package com.jasperalani.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.jasperalani.IMSMain;

public class SettingsGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JButton clearProducts;
	
	public SettingsGUI() {
		
		clearProducts = new JButton("Clear Products");
		add(clearProducts);
		clearProducts.addActionListener(this);
		
		setSize(200, 200);
		setResizable(false);
		setTitle("Settings");
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		
	}
	
	public void actionPerformed (ActionEvent e) {
		if(e.getSource() == clearProducts) {
			IMSMain.products.clear();
			IMSMain.saveProducts();
		}
	}
	
	public static void main (String[] args) {}

}
