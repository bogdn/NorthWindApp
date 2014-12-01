package pl.edu.agh.northwind.NorthwindApp.models;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.AbstractTableModel;

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
		
		List<Employee> employees = new ArrayList<>();
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("northwind");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        Query query = entityManager.createQuery("from Employee");
        employees = query.getResultList();

        entityManager.getTransaction().commit();
		
        Object[][] rows = new Object[getColumnCount()][employees.size()+11];
		
        for (Object[] objects : rows) {
        	for (Object object : objects) {
        		object = "ss";
				
			}
			
		}
        System.out.println(rows[2][2]);
//        entityManagerFactory.close();
//        entityManager.close();
		return rows;
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
