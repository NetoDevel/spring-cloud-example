package br.com.netodevel.loggerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.netodevel.loggerservice.domain.Logger;
import br.com.netodevel.loggerservice.repository.LoggerRepository;

@Service
public class LoggerService {

	@Autowired
	private LoggerRepository loggerRepository;
	
	public Logger save(Logger logger) {
		return loggerRepository.save(logger);
	}
	
}
