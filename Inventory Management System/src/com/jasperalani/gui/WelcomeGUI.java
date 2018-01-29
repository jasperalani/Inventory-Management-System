package com.jasperalani.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WelcomeGUI extends JFrame implements ActionListener {

	// Strings	
	String strTitle = "Inventory Management System";
	String welcome = "Welcome to your personal IMS.";
	String welcome2 = "Please start by entering your name.";
	public static String userName = "error";
		
	private static final long serialVersionUID = 1L;
		
	JTextField userNameTF;
	
	public WelcomeGUI () {
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
					
		add(new JLabel("<html><div style='text-align: center;'>" + welcome + "<br>" + welcome2 + "</div></html>"));
			
		userNameTF = new JTextField(10);
		add(userNameTF);
			
		JButton btnContinue = new JButton("Continue");
		add(btnContinue);
		btnContinue.addActionListener(this);
			
		setResizable(false);
		setSize(220, 150);
		setTitle(strTitle);
		setLocationRelativeTo(null);
			
		setVisible(true);
			
	}
		
	public static void main (String[] args) {
		new WelcomeGUI();
	}
		
	public void actionPerformed(ActionEvent evt) {
		userName = userNameTF.getText().toString();
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("userdata.txt"));
		    writer.write(userName);
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setVisible(false);
		new IMSGUI().setVisible(true);
	}
}
