package com.binsin.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.binsin.store.model.Cart;
import com.binsin.store.model.CartItem;
import com.binsin.store.model.Product;
import com.binsin.store.model.User;
import com.binsin.store.service.CartItemService;
import com.binsin.store.service.CartService;
import com.binsin.store.service.ProductService;
import com.binsin.store.service.UserService;

@RestController
@RequestMapping("/api/cart")
public class CartRestController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/{cartId}", method=RequestMethod.GET)
	public ResponseEntity<Cart> getCartById(@PathVariable(value="cartId") int cartId) {
		Cart cart = cartService.getCartById(cartId);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{cartId}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> clearCart(@PathVariable(value="cartId") int cartId) {
		Cart cart = cartService.getCartById(cartId);
		cartItemService.removeAllCartItems(cart);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/add/{productId}", method=RequestMethod.PUT)
	public ResponseEntity<Void> addItem(@PathVariable(value="productId") int productId) {
		
		Product product = productService.getProductById(productId);
		
		// 현재 로그인한 사용자의 신상 정보를 가져옴
		// servlet-context에 AuthenticationPrincipalArgumentResolver Class 빈 등록
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
				
		User user = userService.getUserByUsername(username);
		Cart cart = user.getCart();
		
		List<CartItem> cartItems = cart.getCartItems();
		
		for(CartItem item : cartItems) {
			if(product.getId() == item.getProduct().getId()) {
				item.setQuantity(item.getQuantity()+1);
				item.setTotalPrice(product.getPrice() * item.getQuantity());
				cartItemService.addCartItem(item);
				
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
		cartItem.setProduct(product);
		cartItem.setCart(cart);
		
		// bidirectional(양방향)
		cart.getCartItems().add(cartItem);
		
		cartItemService.addCartItem(cartItem);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value="/cartitem/{productId}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> removeItem(@PathVariable(value="productId") int productId) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		User user = userService.getUserByUsername(username);
		Cart cart = user.getCart();
		
		CartItem cartItem = cartItemService.getCartItemByProductId(cart.getId(), productId);
		cartItemService.removeCartItem(cartItem);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
