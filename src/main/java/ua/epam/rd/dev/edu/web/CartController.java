package ua.epam.rd.dev.edu.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;



import ua.epam.rd.dev.domain.infrastructure.TotalOrderCostCalculator;
import ua.epam.rd.dev.edu.domain.AccumulativeCard;
import ua.epam.rd.dev.edu.domain.Customer;
import ua.epam.rd.dev.edu.domain.Order;
import ua.epam.rd.dev.edu.domain.Pizza;
import ua.epam.rd.dev.edu.domain.Status;
import ua.epam.rd.dev.edu.service.AccumulativeCardService;
import ua.epam.rd.dev.edu.service.CustomerService;
import ua.epam.rd.dev.edu.service.OrderService;

@RequestMapping(value = "cart")
@Controller
@SessionAttributes("pizzaMap")
public class CartController extends AbstractPizzaController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccumulativeCardService cardService;
	@Autowired
	private TotalOrderCostCalculator totalOrderCostCalc;

	@RequestMapping(value = "/")
	public String viewCart(
			@ModelAttribute("pizzaMap") Map<Pizza, Integer> pizzaMap,
			Model model) {
		addCustomerToModel(model);
		return "cart";
	}

	@RequestMapping(value = "/menu")
	public String viewMenu(Model model) {
		if (!model.containsAttribute("pizzaMap")) {
			model.addAttribute("pizzaMap", new HashMap<Pizza, Integer>());
		}
		List<Pizza> pizzas = pizzaService.getAllPizzas();
		model.addAttribute("pizzasList", pizzas);
		addCustomerToModel(model);
		return "menu";
	}
	
	@RequestMapping(value = "/addToCart")
	public String addPizzaToCart(@RequestParam("pizzaId") Pizza pizza,
			@RequestParam("quantity") Integer quantity,
			@ModelAttribute("pizzaMap") Map<Pizza, Integer> pizzaMap,
			Model model) {
		if (pizzaMap.get(pizza) != null) {
			pizzaMap.put(pizza, pizzaMap.get(pizza) + quantity);
		} else {
			pizzaMap.put(pizza, quantity);
		}
		return "redirect:menu";
	}
	
	@RequestMapping(value = "/remove")
	public String removePizzaFromCart(
			@ModelAttribute("pizzaMap") Map<Pizza, Integer> pizzaMap,
			@RequestParam(value="pizzaId") Pizza pizza,
			Model model) {
		pizzaMap.remove(pizza);
		return "redirect:";
	}

	private void addCustomerToModel(Model model) {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		model.addAttribute("customer", customerService.getByEmail(authentication.getName()));
	}
	
	@RequestMapping(value = "/placeOrder")
	public String placeOrder(
			@ModelAttribute("pizzaMap") Map<Pizza, Integer> pizzaMap) {
		String email = SecurityContextHolder.getContext().getAuthentication()
				.getName();
		Customer customer = customerService.getByEmail(email);
		AccumulativeCard card = customer.getAccumulativeCard();
		double totalSumm = totalOrderCostCalc
				.calculateToatalOrderPriceWithoutCardDiscount(pizzaMap);
		double discount = totalOrderCostCalc.calculateOrderDiscount(pizzaMap,
				card);
		Order order = new Order(customer, Status.ORDERED, totalSumm, discount,
				pizzaMap);
		card.setTotalSumm(card.getTotalSumm() + totalSumm);
		orderService.save(order);
		cardService.update(card);
		System.out.println(order);
		return "redirect:";
	}

	@RequestMapping(value = "/viewPizzas")
	public String viewPizzasFromOrder(
			@RequestParam(value = "orderId") long orderId, Model model) {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		Customer customer = customerService
				.getByEmail(authentication.getName());
		model.addAttribute("customer", customer);
		model.addAttribute("pizzas", orderService.findById(orderId)
				.getPizzas());
		return "pizzasFromOrder";
	}

	@RequestMapping(value = "/account")
	public String viewAccount(Model model) {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		Customer customer = customerService
				.getByEmail(authentication.getName());
		model.addAttribute("customer", customer);
		model.addAttribute("orders",
				orderService.findOrdersByCustomerId(customer.getId()));
		return "account";
	}

}
