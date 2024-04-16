package com.example.foodTownEntities.serviceimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodTownEntities.entity.Customer;
import com.example.foodTownEntities.repository.CustomerRepository;
import com.example.foodTownEntities.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	 private CustomerRepository CustomerRepo;
	@Override
	public Customer addCustomer(Customer Customer) {
		// TODO Auto-generated method stub
		return CustomerRepo.save(Customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return CustomerRepo.findAll();
	}

	@Override
	public Customer getCustomerById(Long CustomerId) {
		// TODO Auto-generated method stub
		return CustomerRepo.findById(CustomerId).get();
	}

	@Override
	public Customer updateCustomer(Long CustomerId, Customer Customer) {
		// TODO Auto-generated method stub
		Customer a=CustomerRepo.findById(CustomerId).get();
		a.setName(Customer.getName());
		a.setEmail(Customer.getEmail());
		a.setAddress(Customer.getAddress());
		a.setPhno(Customer.getPhno());
		return CustomerRepo.save(a);
	}

	@Override
	public void deleteCustomerById(Long CustomerId) {
		// TODO Auto-generated method stub
		CustomerRepo.deleteById(CustomerId);
	}

	@Override
	public void deleteAllCustomer() {
		// TODO Auto-generated method stub
		CustomerRepo.deleteAll();
	}

	@Override
	public boolean isCustomerExists(Long CustomerId) {
		// TODO Auto-generated method stub
		return CustomerRepo.existsById(CustomerId);
	}

}
