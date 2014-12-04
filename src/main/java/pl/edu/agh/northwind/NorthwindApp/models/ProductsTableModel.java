package pl.edu.agh.northwind.NorthwindApp.models;

import java.lang.reflect.Field;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import pl.edu.agh.northwind.NorthwindApp.dao.ProductsDAO;
import pl.edu.agh.northwind.NorthwindApp.entities.Customer;
import pl.edu.agh.northwind.NorthwindApp.entities.Employee;
import pl.edu.agh.northwind.NorthwindApp.entities.Product;

public class ProductsTableModel extends AbstractTableModel {
	ProductsDAO productsDAO = new ProductsDAO();
	private Field[] columnNames;
	private List<Product> objects;

	public ProductsTableModel() {
		columnNames = getColumnNamesFromDatabase();
		objects = getRows();
		System.out.println(objects);
	}

	// Implementing ListAllInterface methods
	public Field[] getColumnNamesFromDatabase() {
		return Customer.class.getDeclaredFields();
	}

	public List<Product> getRows() {
		return productsDAO.findAll();
	}

	// Implementing AbstractTableModel methods
	public int getRowCount() {
		return objects.size();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return objects.get(rowIndex);
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public String getColumnName(int column) {
		return columnNames[column].getName();
	}

}
