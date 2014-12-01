package pl.edu.agh.northwind.NorthwindApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pl.edu.agh.northwind.NorthwindApp.entities.Customer;

public class CustomerDAO {
	private static final Logger logger = Logger.getLogger(CustomerDAO.class
			.getName());

	public void createCustomer(Customer customer) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("nortwind");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(customer);
		entityManager.getTransaction().commit();
		entityManagerFactory.close();
		entityManager.close();
		logger.info("Just added new customer");

	}

	public List<Customer> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("nortwind");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();

		List<Customer> customers = new ArrayList<>();
		Query query = entityManager.createQuery("from Customer");
		customers = query.getResultList();
		entityManager.getTransaction().commit();

		entityManagerFactory.close();
		entityManager.close();

		logger.info("Received all customers");

		return customers;
	}
}
