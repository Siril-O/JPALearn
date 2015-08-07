package ua.epam.rd.dev.edu.service;

import java.util.List;

import ua.epam.rd.dev.edu.domain.Order;

public interface OrderService {

	public Long save(Order order);
	
	public List<Order> findAllOrders();
	
}
