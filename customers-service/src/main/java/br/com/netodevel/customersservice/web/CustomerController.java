package br.com.netodevel.customersservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.netodevel.customersservice.domain.Customer;
import br.com.netodevel.customersservice.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/{customer_id}")
	public ResponseEntity<?> show(@PathVariable("customer_id") Integer customerId) {
		if (customerService.findOne(customerId).isPresent()) {
			Customer customer = customerService.findOne(customerId).get();
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);	
		} else {
			return new ResponseEntity<String>("product not found.", HttpStatus.OK);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		Customer customerSaved = customerService.save(customer);
		return new ResponseEntity<Customer>(customerSaved, HttpStatus.OK);
	}
	
}
