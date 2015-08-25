package ua.epam.rd.dev.edu.repository;

import java.util.List;

import ua.epam.rd.dev.edu.domain.Order;

public interface OrderRepository {

	public Long save(Order order);
	
	public List<Order> findAllOrders();
	
	public Order findById(Long id);
	
	public List<Order> findOrdersByCustomerId(Long customerId);
}
