package pl.edu.agh.northwind.NorthwindApp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class HibernateUtil {
	private static EntityManager entityManager;

	
	private HibernateUtil() {
	}
	
	public static EntityManager getEntityManager()
	{
		if(entityManager == null)
		{
			EntityManagerFactory entityManagerFactory = Persistence
					.createEntityManagerFactory("northwind");
			entityManager = entityManagerFactory
					.createEntityManager();
		}
		
		return entityManager;
	}

}
