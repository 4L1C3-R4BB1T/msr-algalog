package com.algaworks.algalog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Problem {
	
	private Integer status;
	private LocalDateTime dateHour;
	private String title;
	private List<Field> fields;
	
}
