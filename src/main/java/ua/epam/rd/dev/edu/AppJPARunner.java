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
import ua.epam.rd.dev.edu.repository.AddressRepository;
import ua.epam.rd.dev.edu.service.AddressService;
import ua.epam.rd.dev.edu.service.CustomerService;
import ua.epam.rd.dev.edu.service.OrderService;
import ua.epam.rd.dev.edu.service.PizzaService;

public class AppJPARunner {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"appContext.xml");

		PizzaService pizzaService = context.getBean(PizzaService.class);
		CustomerService customerService = context
				.getBean(CustomerService.class);
		AddressService addressService = context.getBean(AddressService.class);
		
		OrderService orderService = context.getBean(OrderService.class);
		
		// Pizza pizza = new Pizza("Oliva", 176.5, PizzaType.Vegetarian);
		// pizzaService.save(pizza);
		// Customer customer = new Customer("Kiril", new AccumulativeCard(), new
		// Address("Kyiv Smth street 21"));
		// customerService.save(customer);

		Map<Pizza, Integer> orderItems = new HashMap<>();

		orderItems.put(pizzaService.findById(3), 2);
		orderItems.put(pizzaService.findById(1), 1);

		Customer customer = customerService.findByid(1);

		Order order = new Order(customer,orderItems);
//		orderService.save(order);
		List<Order> orders = orderService.findAllOrders();
		//System.out.println(orders);
		for(Order o : orders){
			System.out.println(o.getCustomer());
			System.out.println(o.getPizzas());

		}


		System.out.println(pizzaService.getAllPizzas());
		System.out.println(customerService.getAllCustomers());
		System.out.println(addressService.fiandAllAdresses());

	}
}
