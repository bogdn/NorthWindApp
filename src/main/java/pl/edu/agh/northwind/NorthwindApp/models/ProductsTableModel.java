package pl.edu.agh.northwind.NorthwindApp.models;

import java.lang.reflect.Field;
import java.util.ArrayList;
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
	private List<String> columnNames;
	private List<Product> objects;

	public ProductsTableModel() {
		columnNames = getColumns();
		objects = getRows();
		System.out.println(objects);
	}

	public List<String> getColumns() {
		ArrayList<String> columns = new ArrayList<>();

		columns.add("Name");
		columns.add("Category");
		columns.add("Supplier");

		return columns;
	}

	public List<Product> getRows() {
		return productsDAO.findAll();
	}

	// Implementing AbstractTableModel methods
	public int getRowCount() {
		return objects.size();
	}

	public int getColumnCount() {
		return columnNames.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return getValue(objects.get(rowIndex), columnNames.get(columnIndex));
	}

	private String getValue(Product product, String column) {
		try {
			switch (column) {
			case "Name":
				return product.getProductName();
			case "Category":
				return product.getCategory().getCategoryName();
			case "Supplier":
				return product.getSupplier().getCompanyName();
			default:
				return "";
			}
		} catch (NullPointerException e) {
			return "";
		}

	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public String getColumnName(int column) {
		return columnNames.get(column);
	}

}
