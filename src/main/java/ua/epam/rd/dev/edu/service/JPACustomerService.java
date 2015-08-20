package ua.epam.rd.dev.edu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.epam.rd.dev.edu.domain.Customer;
import ua.epam.rd.dev.edu.repository.CustomerRepository;

@Service
public class JPACustomerService implements CustomerService {

	@Autowired
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
	public Customer findByid(Long id) {
		return customerRepository.findByid(id);
	}

	@Override
	public Customer getByEmailAndPassword(String email, String password) {
		return customerRepository.getByEmailAndPassword(email, password);
	}

}
