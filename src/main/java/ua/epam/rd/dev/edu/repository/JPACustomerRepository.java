package ua.epam.rd.dev.edu.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.epam.rd.dev.edu.domain.Customer;

@Repository
public class JPACustomerRepository implements CustomerRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Customer customer) {
		em.persist(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c",
				Customer.class);
		return query.getResultList();
	}

	@Override
	public Customer findByid(long id) {
		return em.find(Customer.class, id);
	}

}
