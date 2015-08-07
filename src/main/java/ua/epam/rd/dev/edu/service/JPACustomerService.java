package ua.epam.rd.dev.edu.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import ua.epam.rd.dev.edu.domain.Customer;
import ua.epam.rd.dev.edu.repository.CustomerRepository;

@Named
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
