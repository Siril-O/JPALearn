package ua.epam.rd.dev.edu.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.epam.rd.dev.edu.domain.Order;

@Repository
public class JPAOrderRepository implements OrderRepository {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	@Override
	public Long save(Order order) {
		em.persist(order);
		return order.getId();
	}

	@Override
	public List<Order> findAllOrders() {
		TypedQuery<Order> query = em.createNamedQuery("Order.findAllOrders",
				Order.class);
		return query.getResultList();
	}

	@Override
	public Order findById(Long id) {
		return em.find(Order.class, id);
	}

	@Override
	public List<Order> findOrdersByCustomerId(Long customerId) {
		TypedQuery<Order> query = em.createNamedQuery("Order.findOrdersByCustomerId",
				Order.class);
		return query.setParameter("customer", customerId).getResultList();
	}

}
