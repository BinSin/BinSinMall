package com.binsin.store.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.binsin.store.model.Cart;

@Repository
@Transactional
public class CartDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Cart getCartById(int cartId) {
		Session session = sessionFactory.getCurrentSession();
		return (Cart)session.get(Cart.class, cartId);
	}

}
