package ua.epam.rd.dev.edu.web;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.epam.rd.dev.edu.domain.Pizza;

@RequestMapping(value = "pizza")
@Controller(value = "pizzaController")
public class PizzaController extends AbstractPizzaController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewPizzas(Model model) {
		addCustomerToModel(model);
		List<Pizza> pizzas = pizzaService.getAllPizzas();
		model.addAttribute("pizzasList", pizzas);
		return "show";
	}

	@RequestMapping(value = "/editpizza")
	public String showEditPizzaForm(@RequestParam("pizzaId") Pizza pizza,
			Model model) {
		model.addAttribute("pizzaToEdit", pizza);
		return "editpizza";
	}

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/changepizza")
	public String editPizza(@ModelAttribute Pizza pizza) {
		pizzaService.update(pizza);
		return "redirect:";
	}

	@RequestMapping(value = "/addpizza")
	public String showAddForm() {
		return "addpizza";
	}

	@RequestMapping(value = "/create")
	public String createPizza(@ModelAttribute Pizza pizza) {
		pizzaService.save(pizza);
		return "redirect:";
	}

	@RequestMapping(value = "/removepizza")
	public String removePizza(@RequestParam("pizzaId") Long id) {
		pizzaService.remove(id);
		return "redirect:";

	}

	@RequestMapping(value = "/orders")
	public String showAllOrders(Model model) {
		addCustomerToModel(model);
		model.addAttribute("orders", orderService.findAllOrders());
		return "orders";
	}

}
