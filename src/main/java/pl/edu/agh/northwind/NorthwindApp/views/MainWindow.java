package pl.edu.agh.northwind.NorthwindApp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import pl.edu.agh.northwind.NorthwindApp.dao.EmployeeDAO;
import pl.edu.agh.northwind.NorthwindApp.entities.Employee;

/**
 * Hello world!
 *
 */
public class MainWindow extends JFrame {
	private JButton crudButton;
	private JLabel infoLabel;
	private static final String IMG_PATH = "src/main/java/pl/edu/agh/northwind/NorthwindApp/resources/logo_iet.png";
	private JLabel aghIcon;
	public MainWindow() {
		super("NorthwindApp");
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		infoLabel = new JLabel("<html><span style='font-size:18px'>Please choose option below</span></html>");
		infoLabel.setForeground(Color.blue);
		
		infoLabel.setBounds(20, 10, 400, 30);
		
		crudButton = new JButton("CRUD operations");
		crudButton.setBounds(100, 100, 200, 30);
		
		ImageIcon imageIcon = new ImageIcon(IMG_PATH);
		aghIcon = new JLabel(imageIcon);
		aghIcon.setBounds(40, 200, 300, 150);
		
		
		
		// adding components
		add(crudButton);
		add(infoLabel);
		add(aghIcon);
		}
	
	
    public static void main( String[] args ) {
        SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				MainWindow mainWindow = new MainWindow();
				mainWindow.setResizable(false);
				mainWindow.setVisible(true);
				
				
			}
		});
        EmployeeDAO employeeDAO = new EmployeeDAO();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees = (ArrayList<Employee>) employeeDAO.findAll();
        System.out.println(employees);
    }
}
