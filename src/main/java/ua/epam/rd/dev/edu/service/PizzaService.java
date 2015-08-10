package ua.epam.rd.dev.edu.service;

import java.util.List;

import ua.epam.rd.dev.edu.domain.Pizza;

public interface PizzaService {

	public void save(Pizza pizza);

	public Pizza findById(Long id);
	
	public List<Pizza> getAllPizzas();

	public void remove(Long id);
	
	public Long update(Pizza pizza);

}
