package br.com.netodevel.loggerservice.communicator;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("CATEGORIES-SERVICE")
public interface CategoryCommunicator {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	CategoryDTO findOne(@PathVariable("id") Integer id); 
}
