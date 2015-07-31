package ua.epam.rd.dev.edu.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import ua.epam.rd.dev.edu.domain.Pizza;
import ua.epam.rd.dev.edu.repository.PizzaRepository;


@Named
public class SimplePizzaService implements PizzaService {

	@Inject
	private PizzaRepository pizzaRepository;

	public SimplePizzaService(PizzaRepository pizzaRepository) {
		super();
		this.pizzaRepository = pizzaRepository;
	}

	public SimplePizzaService() {
		super();
	}

	/**
	 * @return the pizzaRepository
	 */
	public PizzaRepository getPizzaRepository() {
		return pizzaRepository;
	}

	/**
	 * @param pizzaRepository
	 *            the pizzaRepository to set
	 */
	public void setPizzaRepository(PizzaRepository pizzaRepository) {
		this.pizzaRepository = pizzaRepository;
	}
	
	
@Transactional
	public void save(Pizza pizza) {
		pizzaRepository.save(pizza);
	}

}
