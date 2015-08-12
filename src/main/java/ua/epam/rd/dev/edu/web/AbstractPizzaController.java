package ua.epam.rd.dev.edu.web;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import ua.epam.rd.dev.edu.domain.Pizza;
import ua.epam.rd.dev.edu.service.PizzaService;

public abstract class AbstractPizzaController {

	@Autowired
	protected PizzaService pizzaService;
	
	
	private Pizza getPizzaById(Long id) {
		Pizza pizza = pizzaService.findById(id);
		if (id <= 0)
			throw new IllegalArgumentException("ID<0");
		if (pizza == null)
			throw new NotFoundPizzaException("Pizza Id: " + id + " not found");
		return pizza;
	}
	
	@InitBinder
	private void pizzaBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Pizza.class, new PropertyEditorSupport() {

			@Override
			public void setAsText(String pizzaId) {
				Pizza pizza = null;
				if(pizzaId != null && !pizzaId.trim().isEmpty()){
					Long id = Long.valueOf(pizzaId);
					pizza = getPizzaById(id);
				}
				setValue(pizza);
			}
		});
	}
	
}
