package ua.epam.rd.dev.edu.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.epam.rd.dev.edu.domain.Pizza;
import ua.epam.rd.dev.edu.repository.PizzaRepository;

@Service
public class JPAPizzaService implements PizzaService {

	@Inject
	private PizzaRepository pizzaRepository;

	public JPAPizzaService(PizzaRepository pizzaRepository) {
		super();
		this.pizzaRepository = pizzaRepository;
	}

	public JPAPizzaService() {
		super();
	}

	@Transactional
	@Override
	public void save(Pizza pizza) {
		pizzaRepository.save(pizza);
	}

	@Override
	public Pizza findById(long id) {
		return pizzaRepository.findById(id);
	}

	@Override
	public List<Pizza> getAllPizzas() {
		return pizzaRepository.getAllPizzas();
	}

}
