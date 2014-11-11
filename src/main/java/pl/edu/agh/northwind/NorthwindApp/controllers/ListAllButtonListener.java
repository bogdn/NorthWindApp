package pl.edu.agh.northwind.NorthwindApp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import pl.edu.agh.northwind.NorthwindApp.views.ListAllTable;

public class ListAllButtonListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		System.out.println("List all");
		JButton source =(JButton) e.getSource();
		if(source.getText().contains("employees")) {
			new ListAllTable("employees");
			
		}
		
	}

}
