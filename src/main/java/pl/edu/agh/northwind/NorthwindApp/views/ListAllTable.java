package pl.edu.agh.northwind.NorthwindApp.views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import pl.edu.agh.northwind.NorthwindApp.models.CustomerTableModel;
import pl.edu.agh.northwind.NorthwindApp.models.EmployeeTableModel;

public class ListAllTable extends JFrame {

	private JTable table;
	private JScrollPane scrollPane;

	public ListAllTable(String tableName) {
		super("Listing all members of " + tableName + " table");
		setVisible(true);
		setPreferredSize(new Dimension(900, 600));
		//setExtendedState(JFrame.MAXIMIZED_BOTH); //fullScreen ON /OFF

		table = new JTable();
		
		// select table to list all records
		switch (tableName) {
		case "employees":
			table.setModel(new EmployeeTableModel());
			break;
		case "customers":
			table.setModel(new CustomerTableModel());
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
		getContentPane().validate();
		repaint();
		pack();
	}

}
