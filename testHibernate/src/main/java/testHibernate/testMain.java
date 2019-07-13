package testHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class testMain {

	public static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
	
		/*
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml"); // default 가 hibernate.cfg.xml 이므로 명시하지 않아도 된다.
		sessionFactory = conf.buildSessionFactory();
		*/
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Product product = new Product();
		product.setName("notebook");
		product.setPrice(2000);
		product.setDescription("Awesome notebook!!");
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
	
		session.save(product);
		
		tx.commit();
		session.close();
		
	}
}
