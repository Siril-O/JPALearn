package ua.epam.rd.dev.edu.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Pizza Not found")
public class NotFoundPizzaException extends RuntimeException {

	public NotFoundPizzaException(String string) {
		super(string);
	}

}
