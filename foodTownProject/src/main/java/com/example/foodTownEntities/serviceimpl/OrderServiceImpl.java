package com.example.foodTownEntities.serviceimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.foodTownEntities.entity.Order;
import com.example.foodTownEntities.repository.OrderRepository;
import com.example.foodTownEntities.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	 private OrderRepository OrderRepo;
	@Override
	public Order addOrder(Order Order) {
		// TODO Auto-generated method stub
		return OrderRepo.save(Order);
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return OrderRepo.findAll();
	}

	@Override
	public Order getOrderById(Long OrderId) {
		// TODO Auto-generated method stub
		return OrderRepo.findById(OrderId).get();
	}

	@Override
	public Order updateOrder(Long OrderId, Order Order) {
		// TODO Auto-generated method stub
		Order a=OrderRepo.findById(OrderId).get();
//		a.setCustomer(Order.getCustomer());
		a.setTotal(Order.getTotal());
		return OrderRepo.save(a);
	}

	@Override
	public void deleteOrderById(Long OrderId) {
		// TODO Auto-generated method stub
		OrderRepo.deleteById(OrderId);
	}

	@Override
	public void deleteAllOrder() {
		// TODO Auto-generated method stub
		OrderRepo.deleteAll();
	}

	@Override
	public boolean isOrderExists(Long OrderId) {
		// TODO Auto-generated method stub
		return OrderRepo.existsById(OrderId);
	}

}
