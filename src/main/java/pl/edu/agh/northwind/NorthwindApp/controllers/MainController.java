package pl.edu.agh.northwind.NorthwindApp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.edu.agh.northwind.NorthwindApp.views.MainWindow;
import pl.edu.agh.northwind.NorthwindApp.views.PerformanceResultTable;

public class MainController {
	private MainWindow mainWindow;

	public MainController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;

		mainWindow.addCrudButtonListener(new CrudButtonListener(mainWindow));
		mainWindow.addHomeButtonListener(new HomeButtonController(mainWindow));
		mainWindow.addEmployeesButtonListener(new EmployeesButtonListener());
		mainWindow.addCustomerButtonListener(new CustomerButtonListener());
		mainWindow.addProductsButtonListener(new ProductButtonListener());
		mainWindow.addPerfResultButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new PerformanceResultTable();
			}
		});
	}

}
