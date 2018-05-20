package br.com.netodevel.loggerservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.netodevel.loggerservice.communicator.CustomerDTO;
import br.com.netodevel.loggerservice.communicator.ProductDTO;

public class LoggerResponse {

	@JsonProperty("product")
	private ProductDTO productDto;

	@JsonProperty("customer")
	private CustomerDTO customer;
	
	private String register;

	public ProductDTO getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDTO productDto) {
		this.productDto = productDto;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	
}
