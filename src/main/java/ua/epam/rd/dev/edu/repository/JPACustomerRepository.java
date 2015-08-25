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
		TypedQuery<Customer> query = em.createNamedQuery(
				"Customer.getAllCustomers", Customer.class);
		return query.getResultList();
	}

	@Override
	public Customer findByid(long id) {
		return em.find(Customer.class, id);
	}

	@Override
	public Customer getByEmailAndPassword(String email, String password) {
		TypedQuery<Customer> query = em.createNamedQuery(
				"Customer.getByEmailAndPassword", Customer.class);
		return query.setParameter("email", email)
				.setParameter("password", password).getSingleResult();
	}

	@Override
	public Customer getByEmail(String email) {
		TypedQuery<Customer> query = em.createNamedQuery(
				"Customer.getByEmail", Customer.class);
		return query.setParameter("email", email).getSingleResult();
	}

}
