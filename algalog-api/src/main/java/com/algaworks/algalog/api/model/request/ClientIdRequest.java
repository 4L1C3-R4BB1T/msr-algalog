package com.algaworks.algalog.api.model.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientIdRequest {
	
	@NotNull
	private Long id;

}
