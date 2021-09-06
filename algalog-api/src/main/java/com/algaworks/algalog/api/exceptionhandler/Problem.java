package com.algaworks.algalog.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class Problem {
	
	private Integer status;
	private OffsetDateTime dateTime;
	private String title;
	private List<Field> fields;
	
	@Getter
	@AllArgsConstructor
	public static class Field {
		
		private String name;
		private String message;
		
	}
	
}
