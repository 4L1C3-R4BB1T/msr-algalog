package com.algaworks.algalog.api.model.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceiverRequest {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String street;
	
	@NotBlank
	private String number;
	
	@NotBlank
	private String complement;
	
	@NotBlank
	private String neighborhood;

}
