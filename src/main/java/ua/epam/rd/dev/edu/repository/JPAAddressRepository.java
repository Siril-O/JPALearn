package ua.epam.rd.dev.edu.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.epam.rd.dev.edu.domain.Address;

@Repository
public class JPAAddressRepository implements AddressRepository {

	@PersistenceContext
	EntityManager em;

	@Override
	public void save(Address address) {
		em.persist(address);
	}

	@Override
	public Address findById(long id) {
		return em.find(Address.class, id);
	}

	@Override
	public List<Address> fiandAllAdresses() {
		TypedQuery<Address> query = em.createQuery("SELECT a FROM Address a",
				Address.class);
		return query.getResultList();
	}

}
