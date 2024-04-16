package com.example.foodTownEntities.service;
import java.util.List;

import com.example.foodTownEntities.entity.Order;

public interface OrderService {
Order addOrder(Order Order);
	
	List<Order> getAllOrders();
	
	Order getOrderById(Long OrderId);
	
	Order updateOrder(Long OrderId,Order Order);
	
	void deleteOrderById(Long OrderId);
	
	void deleteAllOrder();
	
	boolean isOrderExists(Long OrderId);
}
