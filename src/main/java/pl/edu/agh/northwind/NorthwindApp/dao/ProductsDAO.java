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

public class ProductsDAO {
	private static final Logger logger = Logger.getLogger(ProductsDAO.class
			.getName());

	public List<Product> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("northwind");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		Query query = entityManager.createQuery("from Product");
		List<Product> products = new ArrayList<>();
		;
		products = query.getResultList();;

		return products;
	}
}
