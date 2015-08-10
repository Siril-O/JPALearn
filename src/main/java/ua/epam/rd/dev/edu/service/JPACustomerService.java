package ua.epam.rd.dev.edu.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ua.epam.rd.dev.edu.domain.Customer;
import ua.epam.rd.dev.edu.repository.CustomerRepository;

@Service
public class JPACustomerService implements CustomerService {

	@Inject
	CustomerRepository customerRepository;

	@Override
	@Transactional
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

	@Override
	public Customer findByid(long id) {
		return customerRepository.findByid(id);
	}

}
