package ua.epam.rd.dev.edu.web;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import ua.epam.rd.dev.edu.domain.Customer;
import ua.epam.rd.dev.edu.service.CustomerService;

//@Component("jPAAuthenticationProvider")
public class JPAAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomerService customerService;

	@Override
	public Authentication authenticate(Authentication authentication)

	throws AuthenticationException {
		String email = authentication.getName();
		String password = authentication.getCredentials().toString();
		Customer customer = null;
		try {
			customer = customerService.getByEmailAndPassword(email, password);
			List<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority(customer.getRole()
					.toString()));
			Authentication auth = new UsernamePasswordAuthenticationToken(
					email, password, grantedAuths);
			return auth;
		} catch (NoResultException ex) {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
