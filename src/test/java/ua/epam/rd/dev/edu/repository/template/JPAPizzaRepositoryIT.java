package ua.epam.rd.dev.edu.repository.template;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ua.epam.rd.dev.edu.domain.Pizza;
import ua.epam.rd.dev.edu.domain.PizzaType;
import ua.epam.rd.dev.edu.repository.PizzaRepository;

public class JPAPizzaRepositoryIT extends RepositoryTestsTemplate {

	@Autowired
	private PizzaRepository pizzaRepository;

	@Test
	public void testSomeMethod() {
		Pizza pizza = new Pizza();
		pizza.setName("Salami");
		pizza.setPrice(123.3);
		pizza.setType(PizzaType.Meat);

		Long id = pizzaRepository.save(pizza);
		assertNotNull(id);
	}
}
