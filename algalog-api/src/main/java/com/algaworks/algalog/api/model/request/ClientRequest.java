package com.algaworks.algalog.api.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequest {
	
	@NotBlank
	@Size(max = 60)
	private String name;
	
	@Email
	@NotBlank
	@Size(max = 255)
	private String email;
	
	@NotBlank
	@Size(max = 20)
	private String phone;

}
