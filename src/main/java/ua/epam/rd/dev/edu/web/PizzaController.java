package ua.epam.rd.dev.edu.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.epam.rd.dev.edu.domain.Pizza;
import ua.epam.rd.dev.edu.service.PizzaService;

@RequestMapping(value = "pizza")
@Controller(value = "pizzaController")
public class PizzaController {

	@Autowired
	PizzaService pizzaService;

	@RequestMapping(value = "/editpizza")
	public String showEditPizzaForm(@RequestParam("id") Long id, Model model) {
		Pizza pizza = pizzaService.findById(id);
		if (id <= 0)
			throw new IllegalArgumentException("ID<0");
		if (pizza == null)
			throw new NotFoundPizzaException("Pizza Id: " + id + " not found");
		model.addAttribute("pizzaToEdit", pizza);
		return "editpizza";
	}

	@RequestMapping(value = "/changepizza")
	public String editPizza(@ModelAttribute Pizza pizza) {
		pizzaService.update(pizza);
		return "redirect:";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewPizzas(Model model) {
		List<Pizza> pizzas = pizzaService.getAllPizzas();

		model.addAttribute("pizzasList", pizzas);
		return "show";
	}

	@RequestMapping(value = "/addpizza")
	public String showAddForm() {
		return "addpizza";
	}

	@RequestMapping(value = "/create")
	public String createPizza(@ModelAttribute Pizza pizza/*
														 * @RequestParam("pizzaName"
														 * ) String name,
														 * 
														 * @RequestParam(
														 * "pizzaPrice") Double
														 * price,
														 * 
														 * @RequestParam("pizzaType"
														 * ) PizzaType type
														 */) {

		// Pizza pizza = new Pizza(name, price, type);
		pizzaService.save(pizza);
		return "redirect:";
		// return viewPizzas(model);
		// return "show";
	}

	@RequestMapping(value = "/removepizza")
	public String removePizza(@RequestParam("id") Long id) {
		pizzaService.remove(id);
		return "redirect:";

	}
}
