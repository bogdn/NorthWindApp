package pl.edu.agh.northwind.NorthwindApp.models;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import pl.edu.agh.northwind.NorthwindApp.dao.EmployeeDAO;
import pl.edu.agh.northwind.NorthwindApp.entities.Employee;

public class EmployeeTableModel extends AbstractTableModel implements
		ListAllInterface {
	private Field[] columnNames;
	private Object[][] data;

	public EmployeeTableModel() {
		columnNames = getColumnNamesFromDatabase();
		data = getRows();
	}
	
	// Implementing ListAllInterface methods
	public Field[] getColumnNamesFromDatabase() {
		return Employee.class.getDeclaredFields();
	}

	public Object[][] getRows() {
		List<Employee> employees = EmployeeDAO.findAll();
		
        Object[][] rows = new Object[employees.size()][getColumnCount()];
		rows[2][3] = new String("test"); 
		for(int i=0; i< employees.size(); i++)
			for(int j=0; j<getColumnCount(); j++) {
				rows[i][j] = getMetadataFromEmployee(employees.get(i), j);
			}
		return rows;
	}
	public Object getMetadataFromEmployee(Employee employee, int index) {
		
		switch (index) {
		case 0:
			return employee.getEmployeeId();
		case 1:
			return employee.getLastName();
		case 2:
			return employee.getFirstName();
		case 3:
			return employee.getTitle();
		case 4:
			return employee.getTitleOfCourtesy();
		case 5:
			return employee.getBirthDate();
		case 6:
			return employee.getHireDate();
		case 7:
			return employee.getAddress();
		case 8:
			return employee.getCity();
		case 9:
			return employee.getRegion();
		case 10:
			return employee.getPostalCode();
		case 11:
			return employee.getCountry();
		case 12:
			return employee.getHomePhone();
		case 13:
			return employee.getExtension();
		case 14:
			return employee.getPhoto();
		case 15:
			return employee.getNotes();
		case 16:
			return employee.getReportsTo();
			
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
