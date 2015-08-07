package ua.epam.rd.dev.edu.repository;

import java.util.List;

import ua.epam.rd.dev.edu.domain.Address;

public interface AddressRepository {

	public void save(Address address);
	
	public Address findById(long id);
	
	public List<Address> fiandAllAdresses();
	
}
