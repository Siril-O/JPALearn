package ua.epam.rd.dev.edu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping(value="/login")
	public String viewLoginPage(){
		return "login";
	}
}
