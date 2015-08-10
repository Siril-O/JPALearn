package ua.epam.rd.dev.edu.web;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ua.epam.rd.dev.edu.domain.Pizza;
import ua.epam.rd.dev.edu.domain.PizzaType;
import ua.epam.rd.dev.edu.service.PizzaService;

@Controller("helloController")
public class HelloSpringMVC {

	@Autowired
	PizzaService pizzaService;

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello SpringMVC";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	// public ModelAndView handleDefaultRequest(HttpServletRequest hsr0,
	// HttpServletResponse hsr1) throws Exception {
	// return new ModelAndView("hello", "msg", new Date());
	public String handleDefaultRequest(Model model) {
		model.addAttribute("msg", new Date());
		return "hello";
	}

	/*@RequestMapping(value = "/pizzas", method = RequestMethod.GET)
	public String viewPizzas(Model model) {
		List<Pizza> pizzas = pizzaService.getAllPizzas();

		model.addAttribute("pizzasList", pizzas);
		return "pizzas";
	}

	@RequestMapping(value = "/formAddPizza", method = RequestMethod.GET)
	public ModelAndView viewPizzaForm(Model model) {
		return new ModelAndView("addPizza");
	}

	@RequestMapping(value = "/addPizza", method = RequestMethod.GET)
	public ModelAndView createPizza(@RequestParam("pizzaName") String name,) {
//		Pizza pizza = new Pizza(hsr.getParameter("pizzaName"),
//				Double.parseDouble(hsr.getParameter("price")),
//				PizzaType.valueOf(hsr.getParameter("type")));
		pizzaService.save(pizza);
		return new ModelAndView("addPizza");

	}*/

}
