package ua.epam.rd.dev.edu.service;

import java.util.List;

import ua.epam.rd.dev.edu.domain.Address;

public interface AddressService {

	public void save(Address address);

	public Address findById(long id);

	public List<Address> fiandAllAdresses();
}
