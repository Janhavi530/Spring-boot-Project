package com.example.foodTownEntities.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodTownEntities.entity.Customer;

import com.example.foodTownEntities.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService CustomerService;
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer Customer)
	{
		Customer a=CustomerService.addCustomer(Customer);
		return new ResponseEntity<>(a,HttpStatus.CREATED);
	}
	@GetMapping("/get/{CustomerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long CustomerId)
	{
		boolean isCustomer=CustomerService.isCustomerExists(CustomerId);
		if(isCustomer)
		{
			Customer a=CustomerService.getCustomerById(CustomerId);
			return new ResponseEntity<>(a,HttpStatus.OK);
		}
		else
		{
			System.out.print("No Customer found");
			return null;
		}
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		return new ResponseEntity<>(CustomerService.getAllCustomers(),HttpStatus.OK);
	}
	@PutMapping("/update/{CustomerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long CustomerId,@RequestBody Customer a)
	{
		boolean isCustomer=CustomerService.isCustomerExists(CustomerId);
		if(isCustomer)
		{
			return new ResponseEntity<>(CustomerService.updateCustomer(CustomerId, a),HttpStatus.OK);
		}
		else {
			System.out.print("No Customer found");
			return null;
		}
	}
	@DeleteMapping("/delete/{CustomerId}")
	public void deleteCustomerById(@PathVariable Long CustomerId)
	{
		boolean isCustomer=CustomerService.isCustomerExists(CustomerId);
		if(isCustomer)
		{
			CustomerService.deleteCustomerById(CustomerId);
		}
		else
		{
			System.out.print("No Customer found");
		}
	}
	@DeleteMapping("/deleteAll")
	public void deleteAllCustomer(){
		CustomerService.deleteAllCustomer();
	}
}
