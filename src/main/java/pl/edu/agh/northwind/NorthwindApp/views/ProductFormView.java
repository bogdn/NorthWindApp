package pl.edu.agh.northwind.NorthwindApp.views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListDataListener;

import pl.edu.agh.northwind.NorthwindApp.dao.EmployeeDAO;
import pl.edu.agh.northwind.NorthwindApp.entities.Category;
import pl.edu.agh.northwind.NorthwindApp.entities.Employee;

public class ProductFormView extends JFrame {
	private String operationType;
	private JLabel nameLabel;
	private JTextField nameTextField;
	
	private JLabel suplierLabel;
	private JComboBox suplierComboBox;
	
	private JLabel categoryLabel;
	private JComboBox categoryComboBox;
	private CategoryComboBoxModel categoryComboBoxModel;
	
	private JLabel quantityPerUnitLabel;
	private JTextField quantityPerUnitTextField;
	
	private JLabel unitPriceLabel;
	private JTextField unitPriceTextField;
	
	private JLabel unitsInStockLabel;
	private JTextField unitsInStockTextField;
	
	private JLabel unitsOnOrderLabel;
	private JTextField unitsOnOrderTextField;
	
	private JLabel reordelLevelLabel;
	private JTextField reordelLevelTextField;
	
	private JLabel discontinuedLabel;
	private JCheckBox discontinuedCheckBox;
	
	private JButton addButton;
	
	private List<Category> categories;
	public ProductFormView(String operationType) {
		super("Adding record to product table");
		this.operationType = operationType;
		setPreferredSize(new Dimension(400, 700));
		setVisible(true);
		setLayout(new GridLayout(20, 1));
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new GridLayout(1, 2));
		nameLabel = new JLabel("First Name:");
		nameTextField = new JTextField();
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);
		add(namePanel);
		
		JPanel suplierPanel = new JPanel();
		suplierPanel.setLayout(new GridLayout(1, 2));
		suplierLabel = new JLabel("Suplier:");
		suplierComboBox = new JComboBox<>(new SuplierComboBoxModel());
		suplierPanel.add(suplierLabel);
		suplierPanel.add(suplierComboBox);
		add(suplierPanel);
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setLayout(new GridLayout(1, 2));
		categoryLabel = new JLabel("Category:");
		categoryComboBoxModel = new CategoryComboBoxModel();
		categoryComboBox = new JComboBox<>(categoryComboBoxModel);
		categoryPanel.add(categoryLabel);
		categoryPanel.add(categoryComboBox);
		add(categoryPanel);
		
		JPanel quantityPanel = new JPanel();
		quantityPanel.setLayout(new GridLayout(1, 2));
		quantityPerUnitLabel = new JLabel("Quantity Per Unit:");
		quantityPerUnitTextField = new JTextField();
		quantityPanel.add(quantityPerUnitLabel);
		quantityPanel.add(quantityPerUnitTextField);
		add(quantityPanel);
		
		JPanel unitPricePanel = new JPanel();
		unitPricePanel.setLayout(new GridLayout(1, 2));
		unitPriceLabel = new JLabel("Unit price:");
		unitPriceTextField = new JTextField();
		unitPricePanel.add(unitPriceLabel);
		unitPricePanel.add(unitPriceTextField);
		add(unitPricePanel);
		
		JPanel unitsInStockLPanel = new JPanel();
		unitsInStockLPanel.setLayout(new GridLayout(1, 2));
		unitsInStockLabel = new JLabel("Units in stock:");
		unitsInStockTextField = new JTextField();
		unitsInStockLPanel.add(unitsInStockLabel);
		unitsInStockLPanel.add(unitsInStockTextField);
		add(unitsInStockLPanel);
		
		JPanel unitsOnOrderPanel = new JPanel();
		unitsOnOrderPanel.setLayout(new GridLayout(1, 2));
		unitsOnOrderLabel = new JLabel("First Name:");
		unitsOnOrderTextField = new JTextField();
		unitsOnOrderPanel.add(unitsOnOrderLabel);
		unitsOnOrderPanel.add(unitsOnOrderTextField);
		add(unitsOnOrderPanel);
		
		JPanel reorderPanel = new JPanel();
		reorderPanel.setLayout(new GridLayout(1, 2));
		reordelLevelLabel = new JLabel("Reorder level:");
		reordelLevelTextField = new JTextField();
		reorderPanel.add(reordelLevelLabel);
		reorderPanel.add(reordelLevelTextField);
		add(reorderPanel);
		
		JPanel discontinuedPanel = new JPanel();
		discontinuedPanel.setLayout(new GridLayout(1, 2));
		discontinuedLabel = new JLabel("Discontinued:");
		discontinuedCheckBox = new JCheckBox();
		discontinuedPanel.add(discontinuedLabel);
		discontinuedPanel.add(discontinuedCheckBox);
		add(discontinuedPanel);
				
		pack();
		
		loadData();
	}
	
	private void loadData() {
		// TODO Auto-generated method stub
		
	}

	private class CategoryComboBoxModel implements ComboBoxModel<String>
	{

		@Override
		public int getSize() {
			// TODO Auto-generated method stub
			return categories != null ? categories.size() : 0;
		}

		@Override
		public String getElementAt(int index) {
			return categories.get(index).getCategoryName();
		}

		@Override
		public void addListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setSelectedItem(Object anItem) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object getSelectedItem() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	private class SuplierComboBoxModel implements ComboBoxModel<Category>
	{

		@Override
		public int getSize() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Category getElementAt(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void addListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setSelectedItem(Object anItem) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object getSelectedItem() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
