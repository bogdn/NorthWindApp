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

import pl.edu.agh.northwind.NorthwindApp.dao.EmployeeDAO;
import pl.edu.agh.northwind.NorthwindApp.entities.Employee;
import pl.edu.agh.northwind.NorthwindApp.models.CustomerTableModel;
import pl.edu.agh.northwind.NorthwindApp.models.EmployeeTableModel;

public class ListAllTable extends JFrame {

	private JTable table;
	private JScrollPane scrollPane;
	private JButton editButton;
	private JButton deleteButton;
	private JPanel buttonsPanel;
	private EmployeeTableModel empModel;
	private JLabel infoLabel;

	public ListAllTable(String tableName) {
		super("Listing all members of " + tableName + " table");
		setVisible(true);
		setPreferredSize(new Dimension(900, 600));
		 //setExtendedState(JFrame.MAXIMIZED_BOTH); //fullScreen ON /OFF

		table = new JTable();

		// select table to list all records
		switch (tableName) {
		case "employees":
			empModel = new EmployeeTableModel();
			table.setModel(empModel);
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

		PopupMenu popupMenu = new PopupMenu();
		MenuItem menuItem = new MenuItem();
		menuItem.setLabel("Delete");
		popupMenu.add(menuItem);

		table.add(popupMenu);
		
		buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		editButton = new JButton("Edit");
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
		
		
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int rowNum = table.getSelectedRow();
				Integer id = (Integer)table.getValueAt(rowNum, 0);
				System.out.println(id);
				
				EmployeeDAO.removeEmployee(id);
				table.setModel(new EmployeeTableModel());
				infoLabel.setText("");
				

			}
		});
		
		
		buttonsPanel.add(editButton);
		buttonsPanel.add(deleteButton);
		
		add(buttonsPanel, BorderLayout.SOUTH);

		pack();
	}

}
