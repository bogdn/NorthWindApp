package pl.edu.agh.northwind.NorthwindApp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.edu.agh.northwind.NorthwindApp.views.MainWindow;

public class CrudButtonListener implements ActionListener {

	private MainWindow mainWindow;

	public CrudButtonListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;

	}

	public void actionPerformed(ActionEvent e) {
		mainWindow.setCrudButtonVisible(false);
		mainWindow.setDatabaseTablesViewVisible(true);

	}

}
