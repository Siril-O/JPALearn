package ua.epam.rd.dev.edu.repository;

import java.util.List;

import ua.epam.rd.dev.edu.domain.Pizza;

public interface PizzaRepository {

	public Long save(Pizza pizza);
	
	public Pizza findById(long id);
	
	public List<Pizza> getAllPizzas();
}
