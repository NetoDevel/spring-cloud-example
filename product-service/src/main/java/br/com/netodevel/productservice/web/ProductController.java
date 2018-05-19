package br.com.netodevel.productservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.netodevel.productservice.domain.Product;
import br.com.netodevel.productservice.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/{product_id}")
	public ResponseEntity<?> show(@PathVariable("product_id") Integer productId) {
		if (productService.findOne(productId).isPresent()) {
			Product product = productService.findOne(productId).get();
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("product not found.", HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/")
	public ResponseEntity<Product> create(@RequestBody Product product) {
		Product productSaved = productService.save(product);
		return new ResponseEntity<Product>(productSaved, HttpStatus.OK);
	}
	
}
