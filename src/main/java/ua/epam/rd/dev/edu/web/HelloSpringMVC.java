package ua.epam.rd.dev.edu.web;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
		model.addAttribute("msg",  new Date());
		return "hello";
	}

	@RequestMapping(value="/pizzas", method=RequestMethod.GET)
	public String viewPizzas(Model model){
		model.addAttribute("pizzas", pizzaService.getAllPizzas());
		return "pizzas";
	}
	
}

