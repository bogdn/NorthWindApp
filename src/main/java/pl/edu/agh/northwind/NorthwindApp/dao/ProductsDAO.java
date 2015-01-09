package pl.edu.agh.northwind.NorthwindApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pl.edu.agh.northwind.NorthwindApp.entities.Customer;
import pl.edu.agh.northwind.NorthwindApp.entities.Product;
import pl.edu.agh.northwind.NorthwindApp.performance.PerformanceManager;
import pl.edu.agh.northwind.NorthwindApp.performance.PerformanceTestHelper;

public class ProductsDAO {
	private static final Logger logger = Logger.getLogger(ProductsDAO.class
			.getName());

	public List<Product> findAll() {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		Query query = entityManager.createQuery("from Product");
		PerformanceTestHelper test = PerformanceManager.getTestHelper("Select all products");
		List<Product> products = new ArrayList<>();
		test.start();
		products = query.getResultList();
		test.stopAndSave();
		return products;
	}
	
	public void deleteProduct(Product product)
	{
		EntityManager entityManager = HibernateUtil.getEntityManager();
		PerformanceTestHelper test = PerformanceManager.getTestHelper("Delete product");
		entityManager.getTransaction().begin();
		test.start();
		entityManager.remove(product);
		entityManager.getTransaction().commit();
		test.stopAndSave();
	}

	public void addProduct(Product product) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		PerformanceTestHelper test = PerformanceManager.getTestHelper("Add product");
		test.start();
		entityManager.getTransaction().begin();
		entityManager.persist(product);
		entityManager.getTransaction().commit();
		test.stopAndSave();
	}
	
	public void updateProduct(Product product) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		PerformanceTestHelper test = PerformanceManager.getTestHelper("Add product");
		test.start();
		entityManager.getTransaction().begin();
		entityManager.merge(product);
		entityManager.getTransaction().commit();
		test.stopAndSave();
	}
}
