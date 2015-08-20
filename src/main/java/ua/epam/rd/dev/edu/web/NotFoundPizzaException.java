package ua.epam.rd.dev.edu.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Pizza Not found")
public class NotFoundPizzaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2747416154342603433L;

	public NotFoundPizzaException(String string) {
		super(string);
	}

}
