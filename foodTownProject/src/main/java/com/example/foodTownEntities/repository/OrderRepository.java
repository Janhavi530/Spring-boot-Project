package com.example.foodTownEntities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodTownEntities.entity.Order;
public interface OrderRepository extends JpaRepository<Order, Long>{

}
