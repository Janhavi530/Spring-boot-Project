package com.example.foodTownEntities.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodTownEntities.entity.Payment;
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
