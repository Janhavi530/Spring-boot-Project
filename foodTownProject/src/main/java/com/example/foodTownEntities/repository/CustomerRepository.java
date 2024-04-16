package com.example.foodTownEntities.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodTownEntities.entity.Customer;
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
