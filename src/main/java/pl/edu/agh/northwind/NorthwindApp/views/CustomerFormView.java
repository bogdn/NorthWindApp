package pl.edu.agh.northwind.NorthwindApp.views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.EntityManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import pl.edu.agh.northwind.NorthwindApp.dao.CustomerDAO;
import pl.edu.agh.northwind.NorthwindApp.dao.HibernateUtil;
import pl.edu.agh.northwind.NorthwindApp.entities.Customer;

public class CustomerFormView extends JFrame {
	private String operationType;
	private JLabel lastNameLabel;
	private JTextField lastNameTF;
	private JLabel firstNameLabel;
	private JTextField firstNameTF;
	private JButton addCustomerButton;
	private Customer customer;
	private JButton editCustomerButton;
	private JLabel titleLabel;
	
	private JTextField titleTF;
	private JLabel titleOfCoutesyLabel;
	private JTextField titleOfCoutesyTF;
	private JLabel birthDateLabel;
	private JTextField birthDateTF;
	private JLabel addressLabel;
	private JTextField addressTF;
	private static EntityManager em = HibernateUtil.getEntityManager();

	public CustomerFormView(String operationType, final Customer customer) {
		super("Adding record to customers table");
		this.customer = customer;
		this.operationType = operationType;
		setPreferredSize(new Dimension(400, 700));
		setVisible(true);
		setLayout(null);
		
		firstNameLabel = new JLabel("Company Name:");
		firstNameTF = new JTextField("");
		firstNameLabel.setBounds(30, 10, 100, 20);
		firstNameTF.setBounds(120, 10, 100, 20);
		add(firstNameLabel);
		add(firstNameTF);

		lastNameLabel = new JLabel("Contact Name:");
		lastNameTF = new JTextField("");
		lastNameLabel.setBounds(30, 40, 100, 20);
		lastNameTF.setBounds(120, 40, 100, 20);
		add(lastNameLabel);
		add(lastNameTF);
		
		titleLabel = new JLabel("Contact title:");
		titleTF = new JTextField("");
		titleLabel.setBounds(30, 70, 100, 20);
		titleTF.setBounds(120, 70, 100, 20);
		add(titleLabel);
		add(titleTF);
		
		titleOfCoutesyLabel = new JLabel("City:");
		titleOfCoutesyTF = new JTextField("");
		titleOfCoutesyLabel.setBounds(30, 110, 100, 20);
		titleOfCoutesyTF.setBounds(120, 110, 100, 20);
		add(titleOfCoutesyLabel);
		add(titleOfCoutesyTF);
		
		addressLabel = new JLabel("Address:");
		addressTF = new JTextField("");
		addressLabel.setBounds(30, 140, 100, 20);
		addressTF.setBounds(120, 140, 100, 20);
		add(addressLabel);
		add(addressTF);
		

		switch (operationType) {

		case "add":
			addCustomerButton = new JButton("Add customer");
			addCustomerButton.setBounds(90, 350, 150, 20);
			add(addCustomerButton);
			addCustomerButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Customer customer = new Customer();
					customer.setCompanyName(firstNameTF.getText());
					customer.setContactName(lastNameTF.getText());
					customer.setContactTitle(titleTF.getText());
					customer.setCity(titleOfCoutesyTF.getText());
					customer.setAddress(addressTF.getText());
					CustomerDAO.createCustomer(customer);
				
					JOptionPane.showMessageDialog(CustomerFormView.this,
							"Added new Customer", "Done !", 1);
					CustomerFormView.this.dispose();

				}
			});

			break;

		case "update":
			firstNameTF.setText((customer.getCompanyName()));

			lastNameTF.setText(customer.getContactName());
			titleTF.setText(customer.getContactTitle());
			titleOfCoutesyTF.setText(customer.getCity());

			editCustomerButton = new JButton("Edit customer");
			editCustomerButton.setBounds(90, 350, 150, 20);
			add(editCustomerButton);
			editCustomerButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					em.getTransaction().begin();
					customer.setCompanyName(firstNameTF.getText());
					customer.setContactName(lastNameTF.getText());
					customer.setContactTitle(titleTF.getText());
					customer.setCity(titleOfCoutesyTF.getText());
					customer.setAddress(addressTF.getText());
					em.getTransaction().commit();
					

					JOptionPane.showMessageDialog(CustomerFormView.this,
							"Updated Customer", "Done !", 1);
					
					CustomerFormView.this.dispose();

				}
			});

		default:
			break;
		}

		pack();

	}

}
