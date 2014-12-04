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

	private static final Logger logger = Logger.getLogger(EmployeeDAO.class
			.getName());

	public static void createEmployee(Employee employee) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("northwind");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.persist(employee);

		entityManager.getTransaction().commit();

		logger.info("Just added new employee");

	}

	public static List<Employee> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("northwind");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();

		List<Employee> employees = new ArrayList<>();
		Query query = entityManager.createQuery("from Employee");
		employees = query.getResultList();
		entityManager.getTransaction().commit();

		logger.info("Received all employees");

		return employees;

	}

}
