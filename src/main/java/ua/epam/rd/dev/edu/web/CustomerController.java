package ua.epam.rd.dev.edu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.epam.rd.dev.edu.service.CustomerService;

@Controller
@RequestMapping(value="customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/register")
	public String viewRegistration(){
		return "register";
	}
}
