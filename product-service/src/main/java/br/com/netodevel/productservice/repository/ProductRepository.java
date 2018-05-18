package br.com.netodevel.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.netodevel.productservice.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	

}
