package ua.epam.rd.dev.edu;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.epam.rd.dev.edu.domain.Pizza;
import ua.epam.rd.dev.edu.domain.PizzaType;
import ua.epam.rd.dev.edu.service.PizzaService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"appContext.xml");

    	PizzaService pizzaService = context.getBean(PizzaService.class);
    	
    	Pizza pizza = new Pizza(0, "Salami", 234.5, PizzaType.Meat);
    	pizzaService.save(pizza);

    }
}
