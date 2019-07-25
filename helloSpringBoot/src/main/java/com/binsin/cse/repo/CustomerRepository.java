package com.binsin.cse.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.binsin.cse.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	Customer findById(Long id);
	
	List<Customer> findByLastName(String lastName);

}