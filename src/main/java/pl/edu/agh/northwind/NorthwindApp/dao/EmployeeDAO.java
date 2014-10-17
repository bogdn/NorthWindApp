package pl.edu.agh.northwind.NorthwindApp.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.edu.agh.northwind.NorthwindApp.entities.Employee;

public class EmployeeDAO {
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private static final Logger logger = Logger.getLogger(EmployeeDAO.class.getName());
	
	public void createEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
		
	}
	
	public List<Employee> findAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Employee");
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees =  (ArrayList<Employee>) query.list();
		logger.info("Received all employees");
		
		return employees;
		
	}

}
