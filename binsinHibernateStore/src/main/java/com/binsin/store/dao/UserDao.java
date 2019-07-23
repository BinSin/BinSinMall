package com.binsin.store.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.binsin.store.model.User;

@Repository
@Transactional
public class UserDao {

	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		// passwordEncoder 에 적용된 암호화 방식으로 encoding
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session.saveOrUpdate(user);
		
		session.flush();
	}
	
	public User getUserById(int userId) {
		Session session = sessionFactory.getCurrentSession();
		
		return (User)session.get(User.class, userId);
	}
	
	@SuppressWarnings("unchecked")
	public User getUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<User> query = session.createQuery("from User where username = ?0");
		query.setParameter(0, username);
		
		return query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<User> query = session.createQuery("from User");
		List<User> userList = query.getResultList();
		
		return userList;
	}
	
}
