package pl.edu.agh.northwind.NorthwindApp.views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import pl.edu.agh.northwind.NorthwindApp.models.CustomerTableModel;
import pl.edu.agh.northwind.NorthwindApp.models.EmployeeTableModel;
import pl.edu.agh.northwind.NorthwindApp.models.ProductsTableModel;

public class ListAllTable extends JFrame {

	private JTable table;
	private JScrollPane scrollPane;

	public ListAllTable(String tableName) {
		super("Listing all members of " + tableName + " table");
		setVisible(true);
		setPreferredSize(new Dimension(900, 600));
		//setExtendedState(JFrame.MAXIMIZED_BOTH); //fullScreen

		table = new JTable();
		
		// select table to list all records
		switch (tableName) {
		case "employees":
			table.setModel(new EmployeeTableModel());
			break;
		case "customers":
			table.setModel(new CustomerTableModel());
			break;
		case "products":
			table.setModel(new ProductsTableModel());
			break;

		default:
			break;
		}
		 // adding table with scroolPane
		scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		add(scrollPane, BorderLayout.CENTER);

		pack();
	}

}
