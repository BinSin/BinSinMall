package com.binsin.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binsin.store.dao.ProductDao;
import com.binsin.store.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	public boolean addProduct(Product product) {
		return productDao.addProduct(product);		
	}

	public boolean deleteProduct(int id) {
		return productDao.deleteProduct(id);
	}

}
