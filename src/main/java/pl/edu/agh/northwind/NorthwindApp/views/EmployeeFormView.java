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

import pl.edu.agh.northwind.NorthwindApp.dao.EmployeeDAO;
import pl.edu.agh.northwind.NorthwindApp.dao.HibernateUtil;
import pl.edu.agh.northwind.NorthwindApp.entities.Employee;

public class EmployeeFormView extends JFrame {
	private String operationType;
	private JLabel lastNameLabel;
	private JTextField lastNameTF;
	private JLabel firstNameLabel;
	private JTextField firstNameTF;
	private JButton addEmployeeButton;
	private Employee employee;
	private JButton editEmployeeButton;
	private JLabel titleLabel;
	private JTextField titleTF;
	private JLabel titleOfCoutesyLabel;
	private JTextField titleOfCoutesyTF;
	private JLabel birthDateLabel;
	private JTextField birthDateTF;
	private JLabel addressLabel;
	private JTextField addressTF;
	private static EntityManager em = HibernateUtil.getEntityManager();

	public EmployeeFormView(String operationType, final Employee employee) {
		super("Adding record to employees table");
		this.employee = employee;
		this.operationType = operationType;
		setPreferredSize(new Dimension(400, 700));
		setVisible(true);
		setLayout(null);
		firstNameLabel = new JLabel("First Name:");
		firstNameTF = new JTextField("");
		firstNameLabel.setBounds(30, 10, 100, 20);
		firstNameTF.setBounds(120, 10, 100, 20);
		add(firstNameLabel);
		add(firstNameTF);

		lastNameLabel = new JLabel("Last Name:");
		lastNameTF = new JTextField("");
		lastNameLabel.setBounds(30, 40, 100, 20);
		lastNameTF.setBounds(120, 40, 100, 20);
		add(lastNameLabel);
		add(lastNameTF);
		
		titleLabel = new JLabel("Title:");
		titleTF = new JTextField("");
		titleLabel.setBounds(30, 70, 100, 20);
		titleTF.setBounds(120, 70, 100, 20);
		add(titleLabel);
		add(titleTF);
		
		titleOfCoutesyLabel = new JLabel("Courtesy:");
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
			addEmployeeButton = new JButton("Add employee");
			addEmployeeButton.setBounds(90, 350, 150, 20);
			add(addEmployeeButton);
			addEmployeeButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Employee employee = new Employee();
					employee.setFirstName(firstNameTF.getText());
					employee.setLastName(lastNameTF.getText());
					employee.setTitle(titleTF.getText());
					employee.setTitleOfCourtesy(titleOfCoutesyTF.getText());
					employee.setAddress(addressTF.getText());
					EmployeeDAO.createEmployee(employee);

					JOptionPane.showMessageDialog(EmployeeFormView.this,
							"Added new Employee", "Done !", 1);
					EmployeeFormView.this.dispose();

				}
			});

			break;

		case "update":
			firstNameTF.setText((employee.getFirstName()));

			lastNameTF.setText(employee.getLastName());
			titleTF.setText(employee.getTitle());
			titleOfCoutesyTF.setText(employee.getTitleOfCourtesy());

			editEmployeeButton = new JButton("Edit employee");
			editEmployeeButton.setBounds(90, 350, 150, 20);
			add(editEmployeeButton);
			editEmployeeButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					em.getTransaction().begin();
					employee.setFirstName(firstNameTF.getText());
					employee.setLastName(lastNameTF.getText());
					employee.setTitle(titleTF.getText());
					employee.setTitleOfCourtesy(titleOfCoutesyTF.getText());
					employee.setAddress(addressTF.getText());
					em.getTransaction().commit();
					

					JOptionPane.showMessageDialog(EmployeeFormView.this,
							"Updated Employee", "Done !", 1);
					
					EmployeeFormView.this.dispose();

				}
			});

		default:
			break;
		}

		pack();

	}

}
