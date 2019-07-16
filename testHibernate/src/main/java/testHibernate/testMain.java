package testHibernate;

import java.util.Date;

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
		
		Category category1 = new Category();
		category1.setName("Computer");
		
		Category category2 = new Category();
		category2.setName("Car");
		
		Product product1 = new Product();
		product1.setName("Notebook");
		product1.setPrice(2000);
		product1.setDescription("Awesome notebook!!");
		product1.setCategory(category1);
		// 양방향
		category1.getProducts().add(product1);
		
		Product product2 = new Product();
		product2.setName("Desktop");
		product2.setPrice(1000);
		product2.setDescription("Powerful notebook!!");
		product2.setCategory(category1);
		category1.getProducts().add(product2);
		
		Product product3 = new Product();
		product3.setName("Sonata");
		product3.setPrice(1200000);
		product3.setDescription("Good car!!");
		product3.setCategory(category2);
		category2.getProducts().add(product3);
		
		Person person1 = new Person();
		person1.setFirstName("sin");
		person1.setLastName("bin");
		
		License license1 = new License();
		license1.setLicenseNumber("1234");
		license1.setIssueDate(new Date());
		license1.setPerson(person1);
		person1.setLicense(license1);
		
		Person person2 = new Person();
		person2.setFirstName("sing");
		person2.setLastName("bing");
		
		License license2 = new License();
		license2.setLicenseNumber("5678");
		license2.setIssueDate(new Date());
		license2.setPerson(person2);
		person2.setLicense(license2);
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
	
		// 저장은 부모쪽 저장
		/*
		session.save(product1);
		session.save(product2);
		session.save(product3);
		*/

		//session.save(category1);
		//session.save(category2);
		
		//session.save(license1);
		//session.save(license2);
		
		session.save(person1);
		session.save(person2);
		
		// session.delete(product1); // product1 -> category1 -> product2
		// session.delete(category1);
		
		tx.commit();
		session.close();
		
	}
}
