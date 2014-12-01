package pl.edu.agh.northwind.NorthwindApp.models;

import java.lang.reflect.Field;

import javax.swing.table.AbstractTableModel;

import pl.edu.agh.northwind.NorthwindApp.entities.Customer;

public class CustomerTableModel extends AbstractTableModel implements
		ListAllInterface {

	private Field[] columnNames;
	private Object[][] data;

	public CustomerTableModel() {
		columnNames = getColumnNamesFromDatabase();
		data = getRows();
	}

	// Implementing ListAllInterface methods
	public Field[] getColumnNamesFromDatabase() {
		return Customer.class.getDeclaredFields();
	}

	public Object[][] getRows() {
		return null;
	}

	// Implementing AbstractTableModel methods
	public int getRowCount() {
		return 2;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return "2";
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public String getColumnName(int column) {
		return columnNames[column].getName();
	}

}