package pl.edu.agh.northwind.NorthwindApp.controllers;

import pl.edu.agh.northwind.NorthwindApp.views.MainWindow;

public class MainController {
	private MainWindow mainWindow;

	public MainController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;

		mainWindow.addCrudButtonListener(new CrudButtonListener(mainWindow));
		mainWindow.addHomeButtonListener(new HomeButtonController(mainWindow));
		mainWindow.addEmployeesButtonListener(new EmployeesButtonListener());
		mainWindow.addCustomerButtonListener(new CustomerButtonListener());
		mainWindow.addProductsButtonListener(new ProductButtonListener());
	}

}
