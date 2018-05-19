package br.com.netodevel.productservice.communicator;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("LOGGER-SERVICE")
public interface LoggerCommunicator {

	
}
