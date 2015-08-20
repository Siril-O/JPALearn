package ua.epam.rd.dev.edu.web;

import java.util.Map;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;




import ua.epam.rd.dev.edu.domain.AccumulativeCard;
import ua.epam.rd.dev.edu.domain.Address;
import ua.epam.rd.dev.edu.domain.Customer;
import ua.epam.rd.dev.edu.domain.Order;
import ua.epam.rd.dev.edu.domain.Pizza;
import ua.epam.rd.dev.edu.domain.Status;
import ua.epam.rd.dev.edu.service.CustomerService;
import ua.epam.rd.dev.edu.service.OrderService;

@RequestMapping(value = "cart")
@Controller
@SessionAttributes("pizzaMap")
public class CartController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/")
	public String viewCart(
			@ModelAttribute("pizzaMap") Map<Pizza, Integer> pizzaMap, Model model) {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		model.addAttribute("userName", authentication.getName());
		model.addAttribute("roles", authentication.getAuthorities());
		return "cart";
	}

	@RequestMapping(value = "/placeOrder")
	public String placeOrder(@ModelAttribute("customer") Customer customer,
			@ModelAttribute("address") Address address,
			@ModelAttribute("pizzaMap") Map<Pizza, Integer> pizzaMap) {
		customer.setAccumulativeCard(new AccumulativeCard());
		customer.setAddress(address);
		customerService.save(customer);
		Order order = new Order(customer, Status.ORDERED, pizzaMap);
		orderService.save(order);
		System.out.println(order);
		return "redirect:";
	}
}
