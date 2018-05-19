package br.com.netodevel.loggerservice.communicator;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("PRODUCT-SERVICE")
public interface ProductCommunicator {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ProductDTO findOne(@PathVariable("id") Integer id); 
}
