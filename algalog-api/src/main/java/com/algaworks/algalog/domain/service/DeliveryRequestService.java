package com.algaworks.algalog.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.DeliveryStatus;
import com.algaworks.algalog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeliveryRequestService {

	private ClientCatalogService clientCatalogService;
	private DeliveryRepository deliveryRepository;
	
	@Transactional
	public Delivery request(Delivery delivery) {
		Client client = clientCatalogService.find(delivery.getClient().getId());
		
		delivery.setClient(client);
		delivery.setStatus(DeliveryStatus.PENDING);
		delivery.setRequestDate(LocalDateTime.now());
		
		return deliveryRepository.save(delivery);
	}
	
}
