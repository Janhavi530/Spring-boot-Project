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

import com.example.foodTownEntities.entity.Payment;
import com.example.foodTownEntities.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private PaymentService PaymentService;
	
	@PostMapping("/add")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment Payment)
	{
		Payment a=PaymentService.addPayment(Payment);
		return new ResponseEntity<>(a,HttpStatus.CREATED);
	}
	@GetMapping("/get/{PaymentId}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long PaymentId)
	{
		boolean isPayment=PaymentService.isPaymentExists(PaymentId);
		if(isPayment)
		{
			Payment a=PaymentService.getPaymentById(PaymentId);
			return new ResponseEntity<>(a,HttpStatus.OK);
		}
		else
		{
			System.out.print("No Payment found");
			return null;
		}
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Payment>> getAllPayment(){
		return new ResponseEntity<>(PaymentService.getAllPayments(),HttpStatus.OK);
	}
	@PutMapping("/update/{PaymentId}")
	public ResponseEntity<Payment> updatePayment(@PathVariable Long PaymentId,@RequestBody Payment a)
	{
		boolean isPayment=PaymentService.isPaymentExists(PaymentId);
		if(isPayment)
		{
			return new ResponseEntity<>(PaymentService.updatePayment(PaymentId, a),HttpStatus.OK);
		}
		else {
			System.out.print("No Payment found");
			return null;
		}
	}
	@DeleteMapping("/delete/{PaymentId}")
	public void deletePaymentById(@PathVariable Long PaymentId)
	{
		boolean isPayment=PaymentService.isPaymentExists(PaymentId);
		if(isPayment)
		{
			PaymentService.deletePaymentById(PaymentId);
		}
		else
		{
			System.out.print("No Payment found");
		}
	}
	@DeleteMapping("/deleteAll")
	public void deleteAllPayment(){
		PaymentService.deleteAllPayment();
	}
}
