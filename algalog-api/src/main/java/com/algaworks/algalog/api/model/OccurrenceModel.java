package com.algaworks.algalog.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OccurrenceModel {

	private Long id;
	private String description;
	private OffsetDateTime recordDate;
	
}
