package pl.edu.agh.northwind.NorthwindApp.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import pl.edu.agh.northwind.NorthwindApp.dao.ProductsDAO;
import pl.edu.agh.northwind.NorthwindApp.entities.Product;
import pl.edu.agh.northwind.NorthwindApp.models.CustomerTableModel;
import pl.edu.agh.northwind.NorthwindApp.models.EmployeeTableModel;

public class ProductsTable extends JFrame implements PerformActionHandler{

	private static final int EDIT_COLUMN_INDEX = 9;
	private static final int DELETE_COLUMN_INDEX = 10;
	
	private JTable table;
	private JScrollPane scrollPane;
	private ProductsTableModel model;
	
	ProductsDAO productsDAO = new ProductsDAO();
	private List<String> columnNames;
	private List<Product> objects;

	public ProductsTable() {
		setVisible(true);
		setPreferredSize(new Dimension(1150, 600));
		//setExtendedState(JFrame.MAXIMIZED_BOTH); //fullScreen

		table = new JTable();
		model = new ProductsTableModel();
		
		columnNames = getColumns();
		
		table.setModel(model);

		 // adding table with scroolPane
		scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		add(scrollPane, BorderLayout.CENTER);
		
		TableButton buttonEditorDelete = new TableButton("Delete");
		buttonEditorDelete.addTableButtonListener(new TableButtonListener() {
		  @Override
		  public void tableButtonClicked(int row, int col) {
			  productsDAO.deleteProduct(objects.get(row));
			  objects.remove(row);
			  model.fireTableDataChanged();
		  }     
		});
		
		TableButton buttonEditorEdit = new TableButton("Edit");
		buttonEditorEdit.addTableButtonListener(new TableButtonListener() {
		  @Override
		  public void tableButtonClicked(int row, int col) {
			  new ProductFormView("edit", objects.get(row)).setHandler(ProductsTable.this);;
		  }     
		});
		
		TableColumn columnEdit = table.getColumnModel().getColumn(EDIT_COLUMN_INDEX);
		columnEdit.setCellRenderer(buttonEditorEdit);
		columnEdit.setCellEditor(buttonEditorEdit);
		columnEdit.setPreferredWidth(100);
		
		TableColumn columnDelete = table.getColumnModel().getColumn(DELETE_COLUMN_INDEX);
		columnDelete.setCellRenderer(buttonEditorDelete);
		columnDelete.setCellEditor(buttonEditorDelete);
		columnDelete.setPreferredWidth(100);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);

		pack();
		
		reloadData();
	}
	
	private void reloadData()
	{
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				objects = getObjects();
				model.fireTableDataChanged();
			}
		}).start();
		
	}
	
	public List<String> getColumns() {
		ArrayList<String> columns = new ArrayList<>();

		columns.add("Name");
		columns.add("Category");
		columns.add("Supplier");
		columns.add("Quantity per unit");
		columns.add("Unit price");
		columns.add("Unit in stock");
		columns.add("Units on order");
		columns.add("Reordel level");
		columns.add("Discontinued");
		columns.add("Edit");
		columns.add("Delete");

		return columns;
	}
	
	public List<Product> getObjects() {
		return productsDAO.findAll();
	}
	
	public class ProductsTableModel extends AbstractTableModel {

		public ProductsTableModel() {
			
		}

		// Implementing AbstractTableModel methods
		public int getRowCount() {
			return objects != null ? objects.size() : 0;
		}

		public int getColumnCount() {
			return columnNames.size();
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			return getValue(objects.get(rowIndex), columnNames.get(columnIndex));
		}

		private Object getValue(Product product, String column) {
			try {
				switch (column) {
				case "Name":
					return product.getProductName();
				case "Category":
					return product.getCategory().getCategoryName();
				case "Supplier":
					return product.getSupplier().getCompanyName();
				case "Quantity per unit":
					return product.getQuantityPerUnit();
				case "Unit price":
					return product.getUnitPrice();
				case "Unit in stock":
					return product.getUnitsInStock();
				case "Units on order":
					return product.getUnitsOnOrder();
				case "Reordel level":
					return product.getReorderLevel();
				case "Discontinued":
					return product.getDiscontinued();
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

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return columnIndex == EDIT_COLUMN_INDEX || columnIndex == DELETE_COLUMN_INDEX;
		}
		
	}

	public class TableButton extends JButton implements TableCellRenderer, TableCellEditor {
		  private int selectedRow;
		  private int selectedColumn;
		  Vector<TableButtonListener> listener;

		  public TableButton(String text) {
		    super(text); 
		    listener = new Vector();
		    addActionListener(new ActionListener() { 
		      public void actionPerformed( ActionEvent e ) { 
		        for(TableButtonListener l : listener) { 
		          l.tableButtonClicked(selectedRow, selectedColumn);
		        }
		      }
		    });
		  }

		  public void addTableButtonListener( TableButtonListener l ) {
		    listener.add(l);
		  }

		  public void removeTableButtonListener( TableButtonListener l ) { 
		    listener.remove(l);
		  }

		  @Override 
		  public Component getTableCellRendererComponent(JTable table,
		    Object value, boolean isSelected, boolean hasFocus, int row, int col) {
		    return this;
		  }

		  @Override
		  public Component getTableCellEditorComponent(JTable table,
		      Object value, boolean isSelected, int row, int col) {
		    selectedRow = row;
		    selectedColumn = col;
		    return this;
		  } 

		  @Override
		  public void addCellEditorListener(CellEditorListener arg0) {      
		  } 

		  @Override
		  public void cancelCellEditing() {
		  } 

		  @Override
		  public Object getCellEditorValue() {
		    return "";
		  }

		  @Override
		  public boolean isCellEditable(EventObject arg0) {
		    return true;
		  }

		  @Override
		  public void removeCellEditorListener(CellEditorListener arg0) {
		  }

		  @Override
		  public boolean shouldSelectCell(EventObject arg0) {
		    return true;
		  }

		  @Override
		  public boolean stopCellEditing() {
		    return true;
		  }
		}
	
	public interface TableButtonListener extends EventListener {
		  public void tableButtonClicked( int row, int col );
		}

	@Override
	public void done() {
		// TODO Auto-generated method stub
		model.fireTableDataChanged();
	}
}



