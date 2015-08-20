package ua.epam.rd.dev.edu.web;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
