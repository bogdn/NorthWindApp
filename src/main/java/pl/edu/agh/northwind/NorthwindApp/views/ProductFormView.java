package pl.edu.agh.northwind.NorthwindApp.views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListDataListener;

import pl.edu.agh.northwind.NorthwindApp.dao.CategoryDAO;
import pl.edu.agh.northwind.NorthwindApp.dao.EmployeeDAO;
import pl.edu.agh.northwind.NorthwindApp.dao.ProductsDAO;
import pl.edu.agh.northwind.NorthwindApp.dao.SupplierDAO;
import pl.edu.agh.northwind.NorthwindApp.entities.Category;
import pl.edu.agh.northwind.NorthwindApp.entities.Employee;
import pl.edu.agh.northwind.NorthwindApp.entities.Product;
import pl.edu.agh.northwind.NorthwindApp.entities.Supplier;

public class ProductFormView extends JFrame {
	private String operationType;
	private JLabel nameLabel;
	private JTextField nameTextField;
	
	private JLabel suplierLabel;
	private JComboBox suplierComboBox;
	private DefaultComboBoxModel<String> suplierComboBoxModel = new DefaultComboBoxModel<>();
	
	private JLabel categoryLabel;
	private JComboBox categoryComboBox;
	private DefaultComboBoxModel<String> categoryComboBoxModel = new DefaultComboBoxModel<>();
	
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
	
	private CategoryDAO categoryDAO = new CategoryDAO();
	private SupplierDAO supplierDAO = new SupplierDAO();
	private ProductsDAO productsDAO = new ProductsDAO();
	
	private List<Category> categories;
	private List<Supplier> suppliers;
	private Product product;
	
	public ProductFormView(String operationType)
	{
		this(operationType, null);
	}
	
	public ProductFormView(String operationType, Product product) {
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
		suplierComboBox = new JComboBox<>(suplierComboBoxModel);
		suplierPanel.add(suplierLabel);
		suplierPanel.add(suplierComboBox);
		add(suplierPanel);
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setLayout(new GridLayout(1, 2));
		categoryLabel = new JLabel("Category:");
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
		
		addButton = new JButton(operationType.toUpperCase());
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				performAction();
			}
		});
		add(addButton);
				
		pack();
				
		this.product = product;
		
		loadData();
	}
	
	private void setSuplier(Supplier supplier) {
		if(supplier == null) return;
		int idx = 0;
		for (Supplier supplier2 : suppliers) {
			if(supplier.getSupplierId() == supplier2.getSupplierId())
			{
				suplierComboBox.setSelectedIndex(idx);
				break;
			}
			idx++;
		}
	}
	
	private void setCategory(Category category) {
		if(category == null) return;
		int idx = 0;
		for (Category category2 : categories) {
			if(category.getCategoryId() == category2.getCategoryId())
			{
				categoryComboBox.setSelectedIndex(idx);
				break;
			}
			idx++;
		}
	}

	private void loadData() {
		categories = categoryDAO.findAll();
		for (Category category : categories) {
			categoryComboBoxModel.addElement(category.getCategoryName());
		}
		
		suppliers = supplierDAO.findAll();
		for (Supplier supplier : suppliers) {
			suplierComboBoxModel.addElement(supplier.getCompanyName());
		}
		
		if(product != null)
		{
			nameTextField.setText(product.getProductName());
			setSuplier(product.getSupplier());
			setCategory(product.getCategory());
			quantityPerUnitTextField.setText(product.getQuantityPerUnit());
			unitPriceTextField.setText(String.valueOf(product.getUnitPrice()));
			unitsInStockTextField.setText(String.valueOf(product.getUnitsInStock()));
			unitsOnOrderTextField.setText(String.valueOf(product.getUnitsOnOrder()));
			reordelLevelTextField.setText(String.valueOf(product.getReorderLevel()));
			discontinuedCheckBox.setSelected(product.getDiscontinued());
		}
	}
	
	private void performAction() {
		if(product == null)
		{
			product = new Product();
		}
		
		product.setProductName(nameTextField.getText());
		product.setSupplier(suppliers.get(suplierComboBox.getSelectedIndex()));
		product.setCategory(categories.get(categoryComboBox.getSelectedIndex()));
		product.setQuantityPerUnit(quantityPerUnitTextField.getText());
		product.setUnitPrice(Float.parseFloat(unitPriceTextField.getText()));
		product.setUnitsInStock(Short.parseShort(unitsInStockTextField.getText()));
		product.setUnitsOnOrder(Short.parseShort(unitsOnOrderTextField.getText()));
		product.setReorderLevel(Short.parseShort(reordelLevelTextField.getText()));
		product.setDiscontinued(discontinuedCheckBox.isSelected());
		
		if(operationType.equalsIgnoreCase("add"))
		{
			productsDAO.addProduct(product);
		}
		else if (operationType.equalsIgnoreCase("edit")) {
			productsDAO.editProduct(product);
		}
	}
}
