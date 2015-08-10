package ua.epam.rd.dev.edu.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalErrorHandler {

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundPizzaException.class)
	public ModelAndView exceptionHandler(Exception exception,
			HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("ex", exception);
		mav.addObject("url", req.getRequestURL());
		return mav;
	}

}
