package ua.epam.rd.dev.edu.repository;

import java.util.List;

import ua.epam.rd.dev.edu.domain.Customer;

public interface CustomerRepository {

	public void save(Customer customer);	
	
	public Customer findByid(long id);
	
	public List<Customer> getAllCustomers();
	
	public Customer getByEmailAndPassword(String email, String password);
	
	public Customer getByEmail(String email);
}
