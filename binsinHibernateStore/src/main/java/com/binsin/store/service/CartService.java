package com.binsin.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binsin.store.dao.CartDao;
import com.binsin.store.model.Cart;

@Service
public class CartService {

	@Autowired
	private CartDao cartDao;
	
	public Cart getCartById(int cartId) {
		return cartDao.getCartById(cartId);
	}
}
