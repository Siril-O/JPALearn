package ua.epam.rd.dev.edu.web;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ua.epam.rd.dev.edu.domain.Pizza;

@RestController
public class PizzaRESTController extends AbstractPizzaController {

	@RequestMapping(method = RequestMethod.GET, value = "hello")
	public ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hello From RESTController",
				HttpStatus.I_AM_A_TEAPOT);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pizza/{pizzaId}")
	public ResponseEntity<Pizza> getPizzaById(
			@PathVariable("pizzaId") Pizza pizza) {
		if (pizza == null) {
			return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pizza, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/pizza", headers = "Content-Type=application/json")
	public ResponseEntity<?> createNewPizza(@RequestBody Pizza pizza,
			UriComponentsBuilder builder) {
		System.out.println(pizza);
		pizzaService.save(pizza);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/rest/pizza/{id}")
				.buildAndExpand(pizza.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
}
