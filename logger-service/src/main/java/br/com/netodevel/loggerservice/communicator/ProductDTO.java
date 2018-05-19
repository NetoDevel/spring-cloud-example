package br.com.netodevel.loggerservice.communicator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {

	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("description")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
