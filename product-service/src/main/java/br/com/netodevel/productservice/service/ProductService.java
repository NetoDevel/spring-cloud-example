package br.com.netodevel.productservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.netodevel.productservice.domain.Product;
import br.com.netodevel.productservice.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Optional<Product> findOne(Integer productId) {
		return productRepository.findById(productId);
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}
	
}
