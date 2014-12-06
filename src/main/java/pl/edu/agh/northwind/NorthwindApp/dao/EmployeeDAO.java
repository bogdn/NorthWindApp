package pl.edu.agh.northwind.NorthwindApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pl.edu.agh.northwind.NorthwindApp.entities.Employee;

public class EmployeeDAO {
	private static EntityManager entityManager = HibernateUtil.getEntityManager();

	private static final Logger logger = Logger.getLogger(EmployeeDAO.class
			.getName());

	public static void createEmployee(Employee employee) {
		entityManager.getTransaction().begin();

		entityManager.persist(employee);

		entityManager.getTransaction().commit();

		logger.info("Just added new employee");

	}
	public static Employee findEmployee(int id) {
		return entityManager.find(Employee.class, id);
		
	}
	
	public static void removeEmployee(int id) {
		 entityManager.getTransaction().begin();
		Employee emp = findEmployee(id);
		System.out.println("Deleting        : " + emp.getFirstName());
	    if (emp != null) 
	      entityManager.remove(emp);
	    entityManager.getTransaction().commit();
	    
		
	}

	public static List<Employee> findAll() {
		entityManager.getTransaction().begin();

		List<Employee> employees = new ArrayList<>();
		Query query = entityManager.createQuery("from Employee");
		employees = query.getResultList();
		entityManager.getTransaction().commit();

		logger.info("Received all employees");

		return employees;

	}

}
