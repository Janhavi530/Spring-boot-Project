package com.example.foodTownEntities.service;

import java.util.List;
import com.example.foodTownEntities.entity.Payment;
public interface PaymentService {

	Payment addPayment(Payment Payment);
	
List<Payment> getAllPayments();
	
	Payment getPaymentById(Long PaymentId);
	
	Payment updatePayment(Long PaymentId,Payment Payment);
	
	void deletePaymentById(Long PaymentId);
	
	void deleteAllPayment();
	
	boolean isPaymentExists(Long PaymentId);
}
