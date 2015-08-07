package ua.epam.rd.dev.edu.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import ua.epam.rd.dev.edu.domain.Order;
import ua.epam.rd.dev.edu.repository.OrderRepository;

@Named
public class JPAOrderService implements OrderService {

	@Inject
	OrderRepository orderRepository;

	@Override
	@Transactional
	public Long save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public List<Order> findAllOrders() {
		return orderRepository.findAllOrders();
	}

}