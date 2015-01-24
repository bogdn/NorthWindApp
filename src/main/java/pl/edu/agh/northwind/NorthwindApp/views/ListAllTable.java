package pl.edu.agh.northwind.NorthwindApp.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import pl.edu.agh.northwind.NorthwindApp.dao.CustomerDAO;
import pl.edu.agh.northwind.NorthwindApp.dao.EmployeeDAO;
import pl.edu.agh.northwind.NorthwindApp.entities.Customer;
import pl.edu.agh.northwind.NorthwindApp.entities.Employee;
import pl.edu.agh.northwind.NorthwindApp.models.CustomerTableModel;
import pl.edu.agh.northwind.NorthwindApp.models.EmployeeTableModel;

public class ListAllTable extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton editButton;
	private JButton editButtonCustomer;
	private JButton deleteButton;
	private JButton deleteButtonCustomer;
	private JPanel buttonsPanel;
	private JPanel buttonsPanelCustomer;
	private EmployeeTableModel empModel;
	private CustomerTableModel cusModel;
	private JLabel infoLabel;

	public ListAllTable(String tableName) {
		super("Listing all members of " + tableName + " table");
		setVisible(true);
		setPreferredSize(new Dimension(900, 600));
		 //setExtendedState(JFrame.MAXIMIZED_BOTH); //fullScreen ON /OFF
		
		switch (tableName) {
		
		case "employees":
		{
			empModel = new EmployeeTableModel();
			
			table = new JTable();
			table.setModel(empModel);
			scrollPane = new JScrollPane(table,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			add(scrollPane, BorderLayout.CENTER);

			PopupMenu popupMenu = new PopupMenu();
			MenuItem menuItem = new MenuItem();
			menuItem.setLabel("Delete");
			popupMenu.add(menuItem);

			table.add(popupMenu);
			editButton = new JButton("Edit");
			deleteButton = new JButton("Delete");
			buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			buttonsPanel.add(editButton);
			buttonsPanel.add(deleteButton);
			deleteButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
						int rowNum = table.getSelectedRow();
						Integer id = (Integer)table.getValueAt(rowNum, 0);
						System.out.println(id);
						EmployeeDAO.removeEmployee(id);
						table.setModel(new EmployeeTableModel());
						//infoLabel.setText("");
						
						
			}
				});
			editButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
						int rowNum = table.getSelectedRow();
						Integer id = (Integer)table.getValueAt(rowNum, 0);
						System.out.println(id);
						Employee employee = EmployeeDAO.findEmployee(id);
						new EmployeeFormView("update", employee);
						ListAllTable.this.setVisible(false);
				}
			});
			add(buttonsPanel, BorderLayout.SOUTH);
			pack();
			break;
		}
		case "customers":
		{
			cusModel = new CustomerTableModel();
			table = new JTable();
			table.setModel(cusModel);
			scrollPane = new JScrollPane(table,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			add(scrollPane, BorderLayout.CENTER);

			PopupMenu popupMenuC = new PopupMenu();
			MenuItem menuItemC = new MenuItem();
			menuItemC.setLabel("Delete");
			popupMenuC.add(menuItemC);
			table.add(popupMenuC);
			editButtonCustomer = new JButton("Edit");
			deleteButtonCustomer = new JButton("Delete");
			buttonsPanelCustomer = new JPanel(new FlowLayout(FlowLayout.CENTER));
			buttonsPanelCustomer.add(editButtonCustomer);
			buttonsPanelCustomer.add(deleteButtonCustomer);
			deleteButtonCustomer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int rowNum = table.getSelectedRow();
					Integer id = (Integer) table.getValueAt(rowNum, 0);
					System.out.println(id);		
					CustomerDAO.removeCustomer(id);
					table.setModel(new CustomerTableModel());
					//infoLabel.setText("");
				}
			});
			editButtonCustomer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int rowNum = table.getSelectedRow();
					Integer id = (Integer)table.getValueAt(rowNum, 0);
					System.out.println(id);
					Customer customer = CustomerDAO.findCustomer(id);
					new CustomerFormView("update", customer);
					ListAllTable.this.setVisible(false);
			}
		});
			add(buttonsPanelCustomer, BorderLayout.SOUTH);
			pack();
			break;
			
		}

		default:
			break;
		}
	}
	
	public void refreshCustomerTable() {
			table.setModel(new CustomerTableModel());	
	}
	
	public void refreshEmployeeTable() {
		table.setModel(new EmployeeTableModel());
	}

}
