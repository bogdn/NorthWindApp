package pl.edu.agh.northwind.NorthwindApp.models;

import java.lang.reflect.Field;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import pl.edu.agh.northwind.NorthwindApp.dao.CustomerDAO;
import pl.edu.agh.northwind.NorthwindApp.dao.EmployeeDAO;
import pl.edu.agh.northwind.NorthwindApp.entities.Customer;
import pl.edu.agh.northwind.NorthwindApp.entities.Employee;

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
		
		List<Customer> customers = CustomerDAO.findAll();

		Object[][] rows = new Object[customers.size()][getColumnCount()];
		rows[2][3] = new String("test");
		for (int i = 0; i < customers.size(); i++)
			for (int j = 0; j < getColumnCount(); j++) {
				rows[i][j] = getMetadataFromCustomers(customers.get(i), j);
			}
		return rows;
	}

	private Object getMetadataFromCustomers(Customer customer, int index) {
		switch (index) {
		case 0:
			return customer.getCustomerId();
		case 1:
			return customer.getCompanyName();
		case 2:
			return customer.getContactName();
		case 3:
			return customer.getContactTitle();
		case 4:
			return customer.getAddress();
		case 5:
			return customer.getCity();
		case 6:
			return customer.getRegion();
		case 7:
			return customer.getPostalCode();
		case 8:
			return customer.getCountry();
		case 9:
			return customer.getPhone();
		case 10:
			return customer.getFax();

		default:
			return null;
		}
	}

	// Implementing AbstractTableModel methods
	public int getRowCount() {
		return data.length;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public String getColumnName(int column) {
		return columnNames[column].getName();
	}

}
