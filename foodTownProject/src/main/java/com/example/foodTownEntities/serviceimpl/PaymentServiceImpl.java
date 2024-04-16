package com.example.foodTownEntities.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodTownEntities.entity.Admin;
import com.example.foodTownEntities.entity.Payment;
import com.example.foodTownEntities.repository.PaymentRepository;
import com.example.foodTownEntities.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	 @Autowired
	 private PaymentRepository PaymentRepo;

	@Override
	public Payment addPayment(Payment Payment) {
		// TODO Auto-generated method stub
		return PaymentRepo.save(Payment);
	}

	@Override
	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return PaymentRepo.findAll();
	}

	@Override
	public Payment getPaymentById(Long PaymentId) {
		// TODO Auto-generated method stub
		return PaymentRepo.findById(PaymentId).get();
	}

	@Override
	public Payment updatePayment(Long PaymentId, Payment Payment) {
		// TODO Auto-generated method stub
		Payment a=PaymentRepo.findById(PaymentId).get();
		a.setPay_mode(Payment.getPay_mode());
		a.setTotal(Payment.getTotal());
		return PaymentRepo.save(a);
	}

	@Override
	public void deletePaymentById(Long PaymentId) {
		// TODO Auto-generated method stub
		PaymentRepo.deleteById(PaymentId);
	}

	@Override
	public void deleteAllPayment() {
		// TODO Auto-generated method stub
		PaymentRepo.deleteAll();
	}

	@Override
	public boolean isPaymentExists(Long PaymentId) {
		// TODO Auto-generated method stub
		return PaymentRepo.existsById(PaymentId);
	}
    

}
