package utilitarios.hibernate;

import java.util.Properties;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

public final class HibernateHelper {
	
	private HibernateHelper() {}
	
	private static SessionFactory sessionFactory;
	
	private static EntityManagerFactory entityManagerFactory;
	
	/**
	 * Método responsável por criar <b>HibernateHelper.sessionFactory</b> 
	 * 
	 * @param prop propriedades para o Hibernate
	 */
	public static void initializer(Properties prop) {
		
		Configuration cfg = new Configuration();
		
		getEnitites().forEach(x -> cfg.addAnnotatedClass(x));
		
		cfg.addProperties(prop);
		
		sessionFactory = cfg.buildSessionFactory();
	}
	
	/**
	 * Método responsável por criar <b>HibernateHelper.entityManagerFactory</b> quando utilizado persistence.xml
	 * 
	 * @param persistenceUnitName nome da unidade de persistência
	 */
	public static void initializer(String persistenceUnitName) {
		
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
	}
	
	private static Set<Class<?>> getEnitites() {
		return new Reflections("").getTypesAnnotatedWith(Entity.class);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	public static Session openSession() {
		return sessionFactory.openSession();
	}
	
	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
	public static Properties createHibernateProperties(
			String driver, 
			String url, 
			String user, 
			String password, 
			String dialect) {
		
		Properties prop = new Properties();
		
		prop.put("hibernate.connection.driver_class", driver);
		prop.put("hibernate.connection.url", url);
		prop.put("hibernate.connection.username", user);
		prop.put("hibernate.connection.password", password);
		prop.put("hibernate.dialect", dialect);
		prop.put("hibernate.hbm2ddl.auto", "update");
		
		return prop;
	}
}
