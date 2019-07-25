package com.binsin.cse.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binsin.cse.model.Customer;
import com.binsin.cse.repo.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	static Logger logger = LoggerFactory.getLogger(CustomerController.class);
 
	@Autowired
	CustomerRepository repository;
 	
	@GetMapping(value="/customers", produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Customer>> getAll() {
		
		logger.debug("Calling getAll( )" );
				
		List<Customer> list = new ArrayList<>();
		Iterable<Customer> customers = repository.findAll();
 
		customers.forEach(list::add);
		
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
		
	}
	
	@PostMapping(value="/customers")
	public ResponseEntity<Void> postCustomer(@RequestBody Customer customer) {
 
		logger.debug("Calling postCustomer( )" );
		
		String firstName = customer.getFirstName();
		String lastName = customer.getLastName();
				
		repository.save(new Customer(firstName, lastName));
	
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
 
	@GetMapping(value="/customers/{lastName}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> findByLastName(@PathVariable String lastName) {
 
		logger.debug("Calling findByLastName( )" );
		
		List<Customer> customers = repository.findByLastName(lastName);
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@PutMapping(value="/customers/{id}")
	public ResponseEntity<Void> updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
		
		logger.debug("Calling updateCustomer( )" );
		
		Customer currentCustomer = repository.findById(id);
		
		currentCustomer.setFirstName(customer.getFirstName());
		currentCustomer.setLastName(customer.getLastName());
		
		repository.save(currentCustomer);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/customers/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable long id){
		
		logger.debug("Calling deleteCustomer( )" );
		repository.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}