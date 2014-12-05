package pl.edu.agh.northwind.NorthwindApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pl.edu.agh.northwind.NorthwindApp.entities.Category;
import pl.edu.agh.northwind.NorthwindApp.entities.Customer;
import pl.edu.agh.northwind.NorthwindApp.entities.Product;
import pl.edu.agh.northwind.NorthwindApp.entities.Supplier;

public class SupplierDAO {
	private static final Logger logger = Logger.getLogger(SupplierDAO.class
			.getName());

	public List<Supplier> findAll() {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		Query query = entityManager.createQuery("from Supplier");
		List<Supplier> suppliers = new ArrayList<>();
		;
		suppliers = query.getResultList();

		return suppliers;
	}
}
