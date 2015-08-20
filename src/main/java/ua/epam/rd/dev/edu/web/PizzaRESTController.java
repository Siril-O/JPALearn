package ua.epam.rd.dev.edu.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import ua.epam.rd.dev.edu.domain.Order;
import ua.epam.rd.dev.edu.domain.Pizza;
import ua.epam.rd.dev.edu.service.CustomerService;
import ua.epam.rd.dev.edu.service.OrderService;

@RestController
public class PizzaRESTController extends AbstractPizzaController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET, value = "hello")
	public ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hello From RESTController",
				HttpStatus.I_AM_A_TEAPOT);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pizza/{pizzaId}")
	public ResponseEntity<Pizza> getPizzaById(
			@PathVariable("pizzaId") Pizza pizza) {
		if (pizza == null) {
			return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pizza, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/order/{orderId}")
	public ResponseEntity<Order> getOrderById(@PathVariable("orderId") Long orderId) {
		
		Order order = orderService.findById(orderId);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/pizzaMap/{orderId}")
	public ResponseEntity<Map<Pizza, Integer>> getPizzaMap(@PathVariable("orderId") Long orderId) {
		
		Order order = orderService.findById(orderId);

//		orderService.save(order);
//		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(builder.path("/rest/order/{id}")
//				.buildAndExpand(order.getId()).toUri());
		//return new ResponseEntity<>(headers, HttpStatus.CREATED);
		return new ResponseEntity<>(order.getPizzas(),HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/pizzaMap", headers = "Content-Type=application/json")
	public ResponseEntity<Map<Pizza, Integer>> createNewOrder(@RequestBody HashMap<Pizza, Integer> pizzas , UriComponentsBuilder builder) {
		System.out.println(pizzas);
//		orderService.save(order);
//		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(builder.path("/rest/order/{id}")
//				.buildAndExpand(order.getId()).toUri());
		//return new ResponseEntity<>(headers, HttpStatus.CREATED);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/order", headers = "Content-Type=application/json")
	public ResponseEntity<?> createNewOrder(/*@RequestBody Customer customer,@RequestBody Address address,
			@RequestBody Map<Pizza, Integer> pizzas*/@RequestBody Order order, UriComponentsBuilder builder) {

//		customer.setAccumulativeCard(new AccumulativeCard());
//		customer.setAddress(address);
//		customerService.save(customer);
//		Order order = new Order(customer, Status.ORDERED, pizzas);
		orderService.save(order);
		
		orderService.save(order);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/rest/order/{id}")
				.buildAndExpand(order.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/pizza", headers = "Content-Type=application/json")
	public ResponseEntity<?> createNewPizza(@RequestBody Pizza pizza,
			UriComponentsBuilder builder) {
		pizzaService.save(pizza);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/pizza/{id}")
				.buildAndExpand(pizza.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/pizza/{pizzaId}", headers = "Content-Type=application/json")
	public ResponseEntity<?> updatePizza(@RequestBody Pizza pizza,@PathVariable("id") Long pizzaId,
			UriComponentsBuilder builder) {
		pizza.setId(pizzaId);
		pizzaService.update(pizza);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/pizza/{id}")
				.buildAndExpand(pizza.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.OK);
	}
	
}
