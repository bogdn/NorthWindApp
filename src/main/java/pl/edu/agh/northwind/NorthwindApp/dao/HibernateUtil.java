package pl.edu.agh.northwind.NorthwindApp.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	
	private HibernateUtil() {
	}

	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
		Configuration configuration = new Configuration().configure("pl/edu/agh/northwind/NorthWindApp/resources/hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder
				.build());
		}
		return sessionFactory;

	}

}
