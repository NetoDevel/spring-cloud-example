package br.com.netodevel.loggerservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.netodevel.loggerservice.domain.Logger;
import br.com.netodevel.loggerservice.service.LoggerService;

@RestController
public class LoggerController {

	@Autowired
	private LoggerService loggerService;
	
	@PostMapping("/logger")
	public ResponseEntity<Logger> save(@RequestBody Logger logger) {
		Logger loggerSaved = loggerService.save(logger);
		return new ResponseEntity<Logger>(loggerSaved, org.springframework.http.HttpStatus.CREATED);
	}
	
}
