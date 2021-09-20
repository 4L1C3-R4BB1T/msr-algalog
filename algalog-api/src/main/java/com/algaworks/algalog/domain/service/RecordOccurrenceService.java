package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.Occurrence;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RecordOccurrenceService {

	private FindDeliveryService findDeliveryService;
	
	@Transactional
	public Occurrence record(Long deliveryId, String description) {
		Delivery delivery = findDeliveryService.find(deliveryId);
		return delivery.addOccurrence(description);
	}
	
}
