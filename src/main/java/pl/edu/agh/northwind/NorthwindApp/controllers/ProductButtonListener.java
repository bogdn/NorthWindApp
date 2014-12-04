package pl.edu.agh.northwind.NorthwindApp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.edu.agh.northwind.NorthwindApp.views.CrudView;
import pl.edu.agh.northwind.NorthwindApp.views.MainWindow;

public class ProductButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("test");
		CrudView view = new CrudView("products");
		view.addListAllButtonListener(new ListAllButtonListener());
	}

}
