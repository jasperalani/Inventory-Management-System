package com.jasperalani.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;

import com.jasperalani.IMSMain;
import com.jasperalani.Product;

public class RemoveProductGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JFormattedTextField idTF;
	private JButton remove;
	
	public RemoveProductGUI() {
		
		JPanel main = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel enterID = new JLabel("Enter product ID:");
		main.add(enterID);
		
		NumberFormat formatID = NumberFormat.getInstance();
	    NumberFormatter ft2 = new NumberFormatter(formatID);
	    ft2.setValueClass(Integer.class);
	    ft2.setMinimum(0);
	    ft2.setMaximum(Integer.MAX_VALUE);
	    ft2.setAllowsInvalid(false);
	    ft2.setCommitsOnValidEdit(true);
	    idTF = new JFormattedTextField(ft2);
	    idTF.setPreferredSize(new Dimension(150, 20));
	    main.add(idTF);
	    
	    remove = new JButton("Remove");
	    main.add(remove);
	    remove.addActionListener(this);
	    
	    getContentPane().add(main);
		
		setSize(300, 100);
		setResizable(false);
		setTitle("Remove Product");
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		
	}
	
	public static void main(String[] args) {}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == remove) {
			if(!idTF.getText().toString().equals("")) {
				for(int i = 0; i < IMSMain.products.size(); i++) {
					if(IMSMain.products.get(i).getID() == Integer.valueOf(idTF.getText().toString())) {
						IMSMain.products.remove(i);
						IMSMain.saveProducts();
						new IMSGUI();
						this.setVisible(false);
					}
				}
			}
		}
	}
	

}
