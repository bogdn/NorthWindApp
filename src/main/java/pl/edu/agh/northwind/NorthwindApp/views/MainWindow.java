package pl.edu.agh.northwind.NorthwindApp.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import pl.edu.agh.northwind.NorthwindApp.controllers.MainController;
import pl.edu.agh.northwind.NorthwindApp.controllers.ProductButtonListener;
import pl.edu.agh.northwind.NorthwindApp.dao.HibernateUtil;
import pl.edu.agh.northwind.NorthwindApp.entities.Customer;
import pl.edu.agh.northwind.NorthwindApp.entities.Employee;

/**
 * This windows starts when program first run.
 *
 */
public class MainWindow extends JFrame {
	private JButton crudButton;
	private JLabel infoLabel;
	private static final String IMG_PATH = "src/main/java/pl/edu/agh/northwind/NorthwindApp/resources/logo_iet.png";
	private JLabel aghIcon;
	private JPanel centerPanel;
	private JButton employeesButton;
	private JButton customerButton;
	private JButton productsButton;
	private JButton homeButton;
	private JButton performanceResultButton;
	
	public MainWindow() {
		super("NorthwindApp");
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		infoLabel = new JLabel("Select operation below", SwingConstants.CENTER);
		infoLabel.setForeground(Color.blue);
		
		centerPanel = new JPanel();
		centerPanel.setLayout((new BoxLayout(centerPanel, BoxLayout.Y_AXIS)));
		
		crudButton = new JButton("CRUD operations");
		centerPanel.add(crudButton);
		
		performanceResultButton = new JButton("Performance results");
		centerPanel.add(performanceResultButton);
		
		ImageIcon imageIcon = new ImageIcon(IMG_PATH);
		aghIcon = new JLabel(imageIcon);
		
		// adding components
		add(centerPanel, BorderLayout.CENTER);
		add(infoLabel, BorderLayout.NORTH);
		add(aghIcon, BorderLayout.SOUTH);
		
		// CRUD View

		homeButton = new JButton(">> TO HOME <<");
		centerPanel.add(homeButton);
		homeButton.setVisible(false);
		
		employeesButton = new JButton("employees");
		centerPanel.add(employeesButton);
		employeesButton.setVisible(false);
		
		customerButton = new JButton("customer");
		centerPanel.add(customerButton);
		customerButton.setVisible(false);
		
		productsButton = new JButton("products");
		centerPanel.add(productsButton);
		productsButton.setVisible(false);
		
		}
	
	public void addCrudButtonListener(ActionListener al) {
		crudButton.addActionListener(al);
	}
	
	public void addHomeButtonListener(ActionListener al) {
		homeButton.addActionListener(al);
	}
	
	public void addEmployeesButtonListener(ActionListener al) {
		employeesButton.addActionListener(al);
	}
	
	public void addCustomerButtonListener(ActionListener al) {
		customerButton.addActionListener(al);
	}
	
	public void addProductsButtonListener(ActionListener al) {
		productsButton.addActionListener(al);
	}
	
	public void addPerfResultButtonListener(ActionListener al) {
		performanceResultButton.addActionListener(al);
	}
	
	public void setCrudButtonVisible(boolean visible) {
		crudButton.setVisible(visible);
	}
	
	public void setInfoLabel(String text) {
		infoLabel.setText(text);
	}
	public void setDatabaseTablesViewVisible(boolean visible) {
		infoLabel.setText((visible==true) ? "Select table for CRUD examples" : "Select operation below");
		employeesButton.setVisible(visible);
		homeButton.setVisible(visible);
		customerButton.setVisible(visible);
		productsButton.setVisible(visible);
	}
	
	
    public static void main( String[] args ) {
        SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				MainWindow mainWindow = new MainWindow();
				mainWindow.setVisible(true);
				
				new MainController(mainWindow);
				HibernateUtil.getEntityManager();
				
				
			}
		});

        
    }
}
