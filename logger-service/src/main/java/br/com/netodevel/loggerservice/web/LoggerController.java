package br.com.netodevel.loggerservice.web;

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

import br.com.netodevel.loggerservice.domain.Logger;
import br.com.netodevel.loggerservice.service.LoggerService;

@RestController
public class LoggerController {

	@Autowired
	private LoggerService loggerService;
	
	@GetMapping("/loggers")
	public ResponseEntity<List<Logger>> findAll(@RequestBody Logger logger) {
		List<Logger> loggers = loggerService.findAll(logger);
		return new ResponseEntity<List<Logger>>(loggers, org.springframework.http.HttpStatus.OK);
	}
	
	@PostMapping("/logger")
	public ResponseEntity<Logger> save(@RequestBody Logger logger) {
		Logger loggerSaved = loggerService.save(logger);
		return new ResponseEntity<Logger>(loggerSaved, org.springframework.http.HttpStatus.CREATED);
	}
	
	@PutMapping("/logger/{logger_id}")
	public ResponseEntity<Logger> update(@RequestBody Logger logger) {
		Logger loggerSaved = loggerService.save(logger);
		return new ResponseEntity<Logger>(loggerSaved, org.springframework.http.HttpStatus.OK);
	}
	
	@DeleteMapping("/logger/{logger_id}")
	public ResponseEntity<String> delete(@PathVariable("logger_id") Integer loggerId) {
		loggerService.delete(loggerId);
		return new ResponseEntity<String>("logger deleted", org.springframework.http.HttpStatus.OK);
	}
	
}
