package com.binsin.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.binsin.store.model.Product;
import com.binsin.store.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping("/productInventory")
	public String getProducts(Model model) {	// controller -> model
		
		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);
		
		return "productInventory";
	}
	
	// spring form tag library를 사용해서 객체에 매핑을 시켜준다.
	@RequestMapping(value="/productInventory/addProduct", method=RequestMethod.GET)
	public String addProduct(Model model) {
		
		Product product = new Product();
		product.setCategory("컴퓨터");
		
		model.addAttribute("product", product);
		
		return "addProduct";
	}
	
	@RequestMapping(value="/productInventory/addProduct", method=RequestMethod.POST)
	public String addProductPost(Product product) {
		
		if(!productService.addProduct(product))
			System.out.println("Addng product cannot be done");
		
		return "redirect:/admin/productInventory"; // productInventory 라고 해버리면 오류 -> products 로 받는다.
	}
	
	@RequestMapping(value="/productInventory/deleteProduct/{id}", method=RequestMethod.GET)
	public String deleteProduct(@PathVariable int id) {
		
		if(!productService.deleteProduct(id))
			System.out.println("Deleting product cannot be done");
		
		return "redirect:/admin/productInventory";
	}
	
}
