package br.com.netodevel.customersservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.netodevel.customersservice.domain.Customer;
import br.com.netodevel.customersservice.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	public Optional<Customer> findOne(Integer customerId) {
		return customerRepository.findById(customerId);
	}

}
