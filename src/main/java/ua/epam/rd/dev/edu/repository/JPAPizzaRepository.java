package ua.epam.rd.dev.edu.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.epam.rd.dev.edu.domain.Pizza;

@Repository("pizzaRepository")
public class JPAPizzaRepository implements PizzaRepository {

	@PersistenceContext
	private EntityManager em;

	public JPAPizzaRepository() {
		super();
	}

	@Override
	public Long save(Pizza pizza) {
		em.persist(pizza);
		if (pizza != null) {
			return pizza.getId();
		}
		return null;
	}

	@Override
	public Pizza findById(long id) {
		return em.find(Pizza.class, id);
	}

	@Override
	public List<Pizza> getAllPizzas() {

		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p",
				Pizza.class);
		return query.getResultList();
	}
}
