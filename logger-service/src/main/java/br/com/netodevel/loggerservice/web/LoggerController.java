package br.com.netodevel.loggerservice.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.netodevel.loggerservice.communicator.CustomerCommunicator;
import br.com.netodevel.loggerservice.communicator.CustomerDTO;
import br.com.netodevel.loggerservice.communicator.ProductCommunicator;
import br.com.netodevel.loggerservice.communicator.ProductDTO;
import br.com.netodevel.loggerservice.domain.Logger;
import br.com.netodevel.loggerservice.domain.LoggerResponse;
import br.com.netodevel.loggerservice.service.LoggerService;

@RestController
public class LoggerController {

	@Autowired
	private LoggerService loggerService;
	
	@Autowired
	private ProductCommunicator productCommunicator;
	
	@Autowired
	private CustomerCommunicator customerCommunicator;
	
	@GetMapping("/")
	public ResponseEntity<List<LoggerResponse>> findAll() {
		List<Logger> loggers = loggerService.findAll();
		return new ResponseEntity<List<LoggerResponse>>(buildResponse(loggers), org.springframework.http.HttpStatus.OK);
	}
	
	@GetMapping("/products/{product_id}")
	public ResponseEntity<List<LoggerResponse>> findByProductId(@PathVariable("product_id") Integer productId) {
		List<Logger> loggers = loggerService.findByProductId(productId);
		return new ResponseEntity<List<LoggerResponse>>(buildResponse(loggers), org.springframework.http.HttpStatus.OK);
	}
	
	@GetMapping("/customers/{customers_id}")
	public ResponseEntity<List<LoggerResponse>> findByCustomerId(@PathVariable("customers_id") Integer productId) {
		List<Logger> loggers = loggerService.findByCustomerId(productId);
		return new ResponseEntity<List<LoggerResponse>>(buildResponse(loggers), org.springframework.http.HttpStatus.OK);
	}
	
	private List<LoggerResponse> buildResponse(List<Logger> loggers) {
		List<LoggerResponse> loggersResponse = new ArrayList<>();
		for (Logger logger : loggers) {
			ProductDTO productDTO = productCommunicator.findOne(logger.getProductId());
			CustomerDTO customerDTO = customerCommunicator.findOne(logger.getClientId());
			LoggerResponse loggerResponse = new LoggerResponse();
			
			if (productDTO != null && customerDTO != null) {
				loggerResponse.setProductDto(productDTO);
				loggerResponse.setCustomer(customerDTO);
				loggerResponse.setRegister(logger.getRegister());
				
				loggersResponse.add(loggerResponse);
			}
		}
		return loggersResponse;
	}

	@PostMapping("/")
	public ResponseEntity<Logger> save(@RequestBody Logger logger) {
		Logger loggerSaved = loggerService.save(logger);
		return new ResponseEntity<Logger>(loggerSaved, org.springframework.http.HttpStatus.CREATED);
	}
	
	@PutMapping("/{logger_id}")
	public ResponseEntity<?> update(@PathVariable("logger_id") Integer loggerId, @RequestBody Logger logger) {
		if (loggerService.findOne(loggerId).isPresent()) {
			logger.setId(loggerId);
			Logger loggerSaved = loggerService.save(logger);
			return new ResponseEntity<Logger>(loggerSaved, org.springframework.http.HttpStatus.OK);			
		} else {
			return new ResponseEntity<String>("logger not exists.", org.springframework.http.HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/{logger_id}")
	public ResponseEntity<String> delete(@PathVariable("logger_id") Integer loggerId) {
		if (loggerService.findOne(loggerId).isPresent()) {
			loggerService.delete(loggerId);
			return new ResponseEntity<String>("logger deleted", org.springframework.http.HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("logger not exists.", org.springframework.http.HttpStatus.NO_CONTENT);
		}
	}
	
}
