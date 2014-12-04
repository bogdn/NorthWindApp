package pl.edu.agh.northwind.NorthwindApp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pl.edu.agh.northwind.NorthwindApp.views.ListAllTable;

public class ListAllButtonListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		System.out.println("List all");
		JButton source = (JButton) e.getSource();

		if (source.getText().contains("employees")) {
			new ListAllTable("employees");
		}
		else if (source.getText().contains("customers")) {
			new ListAllTable("customers");
		}
		else if(source.getText().contains("products"))
		{
			new ListAllTable("products");
		}

	}

}
