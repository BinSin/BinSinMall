package com.binsin.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binsin.store.dao.CartItemDao;
import com.binsin.store.model.Cart;
import com.binsin.store.model.CartItem;

@Service
public class CartItemService {

	@Autowired
	private CartItemDao cartItemDao;
	
	public void addCartItem(CartItem cartItem) {
		cartItemDao.addCartItem(cartItem);
	}
	
	public void removeCartItem(CartItem cartItem) {
		cartItemDao.removeCartItem(cartItem);
	}
	
	public void removeAllCartItems(Cart cart) {
		cartItemDao.removeAllCartItems(cart);
	}
	
	public CartItem getCartItemByProductId(int cartId, int productId) {
		return cartItemDao.getCartItemByProductId(cartId, productId);
	}
	
}
