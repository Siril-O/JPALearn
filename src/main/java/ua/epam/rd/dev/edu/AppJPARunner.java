package ua.epam.rd.dev.edu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.epam.rd.dev.edu.domain.AccumulativeCard;
import ua.epam.rd.dev.edu.domain.Address;
import ua.epam.rd.dev.edu.domain.Customer;
import ua.epam.rd.dev.edu.domain.Order;
import ua.epam.rd.dev.edu.domain.Pizza;
import ua.epam.rd.dev.edu.domain.PizzaType;
import ua.epam.rd.dev.edu.domain.Role;
import ua.epam.rd.dev.edu.domain.Status;
import ua.epam.rd.dev.edu.repository.AddressRepository;
import ua.epam.rd.dev.edu.service.AccumulativeCardService;
import ua.epam.rd.dev.edu.service.AddressService;
import ua.epam.rd.dev.edu.service.CustomerService;
import ua.epam.rd.dev.edu.service.OrderService;
import ua.epam.rd.dev.edu.service.PizzaService;

public class AppJPARunner {
	public static void main(String[] args) {
		ConfigurableApplicationContext repositoryContext = new ClassPathXmlApplicationContext(
				"repositoryContext.xml");

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "appContext.xml" }, repositoryContext);

		PizzaService pizzaService = context.getBean(PizzaService.class);
		CustomerService customerService = context
				.getBean(CustomerService.class);
		AddressService addressService = context.getBean(AddressService.class);

		OrderService orderService = context.getBean(OrderService.class);

		AccumulativeCardService cardService = context
				.getBean(AccumulativeCardService.class);

		// Pizza pizza = new Pizza("Oliva", 176.5, PizzaType.Vegetarian);
		// pizzaService.save(pizza);
		// Customer customer = new Customer("Kiril", new AccumulativeCard(), new
		// Address("Kyiv Smth street 21"));
		// customerService.save(customer);

		/*
		 * System.out.println("***************Bitch Please****************8");
		 * Map<Pizza, Integer> orderItems = new HashMap<>();
		 * 
		 * orderItems.put(pizzaService.findById(Long.valueOf(3)), 2);
		 * orderItems.put(pizzaService.findById(Long.valueOf(3)), 1);
		 * 
		 * //Customer customer = customerService.findByid(1); //
		 * System.out.println("* " + customer);
		 * 
		 * Customer customer = new Customer("asdadsadassdasda", new
		 * AccumulativeCard(), new Address("sdfsdfsdfsdfd"));
		 * customerService.save(customer); Order order = new Order(customer,
		 * Status.ORDERED, orderItems); // System.out.println("* " + order);
		 * orderService.save(order);
		 */
		List<Order> orders = orderService.findAllOrders();
		// System.out.println(orders);

		for (Order o : orders) {
			System.out.println(o);
			// System.out.println(o.getCustomer());
			// System.out.println(o.getPizzas());

		}

		customerService.save(new Customer("Kiril Kovalchuk", new Address(
				"Kyiv Hnata Uri 16 app. 20"), "123", "megajeday@gmail.com",
				Role.ROLE_ADMIN));

		// System.out.println(pizzaService.getAllPizzas());
		// System.out.println(customerService.getAllCustomers());
		// System.out.println(addressService.fiandAllAdresses());

	}
}
