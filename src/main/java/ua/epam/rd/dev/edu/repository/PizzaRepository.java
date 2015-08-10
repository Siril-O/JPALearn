package ua.epam.rd.dev.edu.repository;

import java.util.List;

import ua.epam.rd.dev.edu.domain.Pizza;

public interface PizzaRepository {

	public Long save(Pizza pizza);

	public Pizza findById(Long id);

	public List<Pizza> getAllPizzas();

	public void remove(Long id);
	
	public Long update(Pizza pizza);
}
