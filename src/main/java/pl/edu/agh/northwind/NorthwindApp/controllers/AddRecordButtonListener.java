package pl.edu.agh.northwind.NorthwindApp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pl.edu.agh.northwind.NorthwindApp.views.CustomerFormView;
import pl.edu.agh.northwind.NorthwindApp.views.EmployeeFormView;
import pl.edu.agh.northwind.NorthwindApp.views.ListAllTable;
import pl.edu.agh.northwind.NorthwindApp.views.ProductFormView;

public class AddRecordButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton source = (JButton) arg0.getSource();
		System.out.println("test");
		if (source.getText().contains("employees")) {
			new EmployeeFormView("add", null);
			System.out.println("adddddd");

		}
		else if (source.getText().contains("products")) {
			new ProductFormView("add");
			System.out.println("teststest");
		}
		else if (source.getText().contains("customers")) {
			new CustomerFormView("add", null);
			
		}


	}

}
