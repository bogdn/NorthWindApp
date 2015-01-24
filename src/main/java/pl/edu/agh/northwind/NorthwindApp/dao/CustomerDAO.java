package pl.edu.agh.northwind.NorthwindApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pl.edu.agh.northwind.NorthwindApp.entities.Customer;
import pl.edu.agh.northwind.NorthwindApp.entities.Employee;

public class CustomerDAO {
	private static final Logger logger = Logger.getLogger(CustomerDAO.class
			.getName());
	private static EntityManager entityManager = HibernateUtil.getEntityManager();

	public static void createCustomer(Customer customer) {
		entityManager.getTransaction().begin();

		entityManager.persist(customer);

		entityManager.getTransaction().commit();

		logger.info("Just added new customer");

	}

	public static List<Customer> findAll() {
		
		entityManager.getTransaction().begin();

		List<Customer> customers = new ArrayList<>();
		Query query = entityManager.createQuery("from Customer");
		customers = query.getResultList();
		entityManager.getTransaction().commit();

		logger.info("Received all customers");

		return customers;
	}
	public static Customer findCustomer(int id) {
		return entityManager.find(Customer.class, id);
		
	}
	
	public static void removeCustomer(int id) {
		 entityManager.getTransaction().begin();
		Customer cus = findCustomer(id);
		System.out.println("Deleting        : " + cus.getCompanyName());
	    if (cus != null) 
	      entityManager.remove(cus);
	    entityManager.getTransaction().commit();
	    
		
	}
}
