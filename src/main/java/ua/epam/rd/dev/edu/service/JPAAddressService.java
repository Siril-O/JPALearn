package ua.epam.rd.dev.edu.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ua.epam.rd.dev.edu.domain.Address;
import ua.epam.rd.dev.edu.repository.AddressRepository;

@Named
public class JPAAddressService implements AddressService {

	@Inject
	AddressRepository addresRepository;

	@Override
	public void save(Address address) {
		addresRepository.save(address);
	}

	@Override
	public Address findById(long id) {
		return addresRepository.findById(id);
	}

	@Override
	public List<Address> fiandAllAdresses() {
		return addresRepository.fiandAllAdresses();
	}

}
