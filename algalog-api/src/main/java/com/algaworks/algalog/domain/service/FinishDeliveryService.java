package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinishDeliveryService {
	
	private DeliveryRepository deliveryRepository;
	private FindDeliveryService findDeliveryService;
	
	@Transactional
	public void finish(Long deliveryId) {
		Delivery delivery = findDeliveryService.find(deliveryId);
		delivery.finish();
		deliveryRepository.save(delivery);
	}

}
