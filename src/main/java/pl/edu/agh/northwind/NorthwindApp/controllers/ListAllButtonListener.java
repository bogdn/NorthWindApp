package pl.edu.agh.northwind.NorthwindApp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pl.edu.agh.northwind.NorthwindApp.views.ListAllTable;
import pl.edu.agh.northwind.NorthwindApp.views.ProductsTable;

public class ListAllButtonListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		System.out.println("List all");
		System.out.println(((JButton) e.getSource()).getText());
		JButton source = (JButton) e.getSource();

		if (source.getText().contains("employees")) {
			new ListAllTable("employees");
		}
		else if (source.getText().contains("customers")) {
			new ListAllTable("customers");
		}
		else if(source.getText().contains("products"))
		{
			new ProductsTable();
		}

	}

}
