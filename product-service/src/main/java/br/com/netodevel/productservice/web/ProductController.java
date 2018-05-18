package br.com.netodevel.productservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.netodevel.productservice.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products/{product_id}/loggers")
	public String findLoggersByProducts(@PathVariable("product_id") Integer productId) {
		return "";
	}
	
}
