package ua.epam.rd.dev.edu.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.epam.rd.dev.edu.domain.Pizza;


@Repository("pizzaRepository")
public class SqlPizzaRepository implements PizzaRepository {

	@PersistenceContext
	private EntityManager entityManager;


	public void save(Pizza pizza) {

		if (entityManager == null) {
			System.out.println("Hell no");
		}
		entityManager.persist(pizza);
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager
	 *            the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
