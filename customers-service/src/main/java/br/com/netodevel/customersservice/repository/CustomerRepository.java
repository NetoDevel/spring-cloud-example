package br.com.netodevel.customersservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.netodevel.customersservice.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
