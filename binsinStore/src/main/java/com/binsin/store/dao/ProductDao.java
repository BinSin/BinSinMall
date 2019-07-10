package com.binsin.store.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.binsin.store.model.Product;

@Repository
public class ProductDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Product> getProducts() {
		
		String sqlStatement = "select * from product";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getInt("price"));
				product.setManufacturer(rs.getString("manufacturer"));
				product.setUnitInStock(rs.getInt("unitInStock"));
				product.setDescription(rs.getString("description"));
				
				return product;
			}
		});
	}

	public Boolean addProduct(Product product) {

		String name = product.getName();
		String category = product.getCategory();
		int price = product.getPrice();
		String manufacturer = product.getManufacturer();
		int unitInStock = product.getUnitInStock();
		String description = product.getDescription();
		
		String sqlStatement = "insert into product (name, category, price, manufacturer, unitInStock, description) values (?, ?, ?, ?, ?, ?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {name,category,price,manufacturer,unitInStock,description}) == 1);
	}

}
