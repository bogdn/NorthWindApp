package pl.edu.agh.northwind.NorthwindApp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.edu.agh.northwind.NorthwindApp.views.MainWindow;

public class HomeButtonController implements ActionListener {
	private MainWindow mainWindow;

	public HomeButtonController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;

	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Returned to home");
		mainWindow.setDatabaseTablesViewVisible(false);
		mainWindow.setCrudButtonVisible(true);

	}

}
