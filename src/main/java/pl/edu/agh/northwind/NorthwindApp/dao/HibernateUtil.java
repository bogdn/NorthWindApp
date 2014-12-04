package pl.edu.agh.northwind.NorthwindApp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static EntityManager entityManager;

	
	private HibernateUtil() {
	}

	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
		Configuration configuration = new Configuration().configure("pl/edu/agh/northwind/NorthwindApp/resources/hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder
				.build());
		}
		return sessionFactory;
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
