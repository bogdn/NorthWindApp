package pl.edu.agh.northwind.NorthwindApp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.edu.agh.northwind.NorthwindApp.views.CrudView;

public class EmployeesButtonListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		System.out.println("Employees Button clicked");
		CrudView view = new CrudView("employees");
		view.addListAllButtonListener(new ListAllButtonListener());
		view.addAddRecordButtonListener(new AddRecordButtonListener());

	}

}
