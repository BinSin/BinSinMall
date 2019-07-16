package com.binsin.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.binsin.store.model.Product;
import com.binsin.store.service.ProductService;

@Controller
public class ProductController { // controller -> service -> dao

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public String getPorducts(Model model) {
		
		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);
		
		return "products"; // view's logical name
	}
	
}
