package ua.epam.rd.dev.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.epam.rd.dev.edu.domain.Address;
import ua.epam.rd.dev.edu.repository.AddressRepository;

@Service
public class JPAAddressService implements AddressService {

	@Autowired
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
