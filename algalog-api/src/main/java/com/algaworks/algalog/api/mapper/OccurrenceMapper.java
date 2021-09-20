package com.algaworks.algalog.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.OccurrenceModel;
import com.algaworks.algalog.domain.model.Occurrence;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class OccurrenceMapper {
	
	private ModelMapper modelMapper;
	
	public OccurrenceModel toModel(Occurrence occurrence) {
		return modelMapper.map(occurrence, OccurrenceModel.class);
	}

}
