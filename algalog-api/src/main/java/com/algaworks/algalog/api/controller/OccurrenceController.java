package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.mapper.OccurrenceMapper;
import com.algaworks.algalog.api.model.OccurrenceModel;
import com.algaworks.algalog.api.model.request.OccurrenceRequest;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.Occurrence;
import com.algaworks.algalog.domain.service.FindDeliveryService;
import com.algaworks.algalog.domain.service.RecordOccurrenceService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/deliveries/{deliveryId}/ocurrences")
public class OccurrenceController {

	private FindDeliveryService findDeliveryService;
	private RecordOccurrenceService recordOccurrenceService;
	private OccurrenceMapper occurenceMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OccurrenceModel record(@PathVariable Long deliveryId, 
			@Valid @RequestBody OccurrenceRequest occurrenceRequest) {
		Occurrence recordedOccurrence = recordOccurrenceService
				.record(deliveryId, occurrenceRequest.getDescription());
		
		return occurenceMapper.toModel(recordedOccurrence);
	}
	
	@GetMapping
	public List<OccurrenceModel> listAllOccurrencesByDelivery(@PathVariable Long deliveryId) {
		Delivery delivery = findDeliveryService.find(deliveryId);
		return occurenceMapper.toCollectionModel(delivery.getOccurrences());
	}
	
}
