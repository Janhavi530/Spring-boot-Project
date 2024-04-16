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

import com.example.foodTownEntities.entity.Order;

import com.example.foodTownEntities.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService OrderService;
	
	@PostMapping("/add")
	public ResponseEntity<Order> addOrder(@RequestBody Order Order)
	{
		Order a=OrderService.addOrder(Order);
		return new ResponseEntity<>(a,HttpStatus.CREATED);
	}
	@GetMapping("/get/{OrderId}")
	public ResponseEntity<Order> getOrder(@PathVariable Long OrderId)
	{
		boolean isOrder=OrderService.isOrderExists(OrderId);
		if(isOrder)
		{
			Order a=OrderService.getOrderById(OrderId);
			return new ResponseEntity<>(a,HttpStatus.OK);
		}
		else
		{
			System.out.print("No Order found");
			return null;
		}
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Order>> getAllOrder(){
		return new ResponseEntity<>(OrderService.getAllOrders(),HttpStatus.OK);
	}
	@PutMapping("/update/{OrderId}")
	public ResponseEntity<Order> updateOrder(@PathVariable Long OrderId,@RequestBody Order a)
	{
		boolean isOrder=OrderService.isOrderExists(OrderId);
		if(isOrder)
		{
			return new ResponseEntity<>(OrderService.updateOrder(OrderId, a),HttpStatus.OK);
		}
		else {
			System.out.print("No Order found");
			return null;
		}
	}
	@DeleteMapping("/delete/{OrderId}")
	public void deleteOrderById(@PathVariable Long OrderId)
	{
		boolean isOrder=OrderService.isOrderExists(OrderId);
		if(isOrder)
		{
			OrderService.deleteOrderById(OrderId);
		}
		else
		{
			System.out.print("No Order found");
		}
	}
	@DeleteMapping("/deleteAll")
	public void deleteAllOrder(){
		OrderService.deleteAllOrder();
	}
}
