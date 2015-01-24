package pl.edu.agh.northwind.NorthwindApp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.edu.agh.northwind.NorthwindApp.views.CrudView;

public class CustomerButtonListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		System.out.println("Customer Button clicked");
		CrudView view = new CrudView("customers");
		view.addListAllButtonListener(new ListAllButtonListener());
		view.addAddRecordButtonListener(new AddRecordButtonListener());

	}
}
