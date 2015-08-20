package ua.epam.rd.dev.edu.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.epam.rd.dev.edu.domain.Pizza;

@RequestMapping(value = "pizza")
@Controller(value = "pizzaController")
@SessionAttributes("pizzaMap")
public class PizzaController extends AbstractPizzaController {

	// @RequestMapping(value="/login")
	// public String showLoginForm(){
	// return "login";
	// }

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

	@RequestMapping(value = "/menu")
	public String viewMenu(Model model) {
		if (!model.containsAttribute("pizzaMap")) {
			model.addAttribute("pizzaMap", new HashMap<Pizza, Integer>());
		}
		List<Pizza> pizzas = pizzaService.getAllPizzas();
		model.addAttribute("pizzasList", pizzas);
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		model.addAttribute("userName", authentication.getName());
		model.addAttribute("roles", authentication.getAuthorities());
		return "menu";
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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewPizzas(Model model) {
		List<Pizza> pizzas = pizzaService.getAllPizzas();

		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		model.addAttribute("userName", authentication.getName());
		model.addAttribute("roles", authentication.getAuthorities());
		model.addAttribute("pizzasList", pizzas);
		return "show";
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

}
