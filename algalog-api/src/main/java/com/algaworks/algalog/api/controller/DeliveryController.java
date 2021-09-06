package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.mapper.DeliveryMapper;
import com.algaworks.algalog.api.model.DeliveryModel;
import com.algaworks.algalog.api.model.request.DeliveryRequest;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;
import com.algaworks.algalog.domain.service.DeliveryRequestService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/deliveries")
public class DeliveryController {

	private DeliveryRepository deliveryRepository;
	private DeliveryRequestService deliveryRequestService;
	private DeliveryMapper deliveryMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DeliveryModel request(@Valid @RequestBody DeliveryRequest deliveryRequest) {
		Delivery delivery = deliveryMapper.toEntity(deliveryRequest);
		Delivery requestedDelivery = deliveryRequestService.request(delivery);
		return deliveryMapper.toModel(requestedDelivery);
	}
	
	@GetMapping
	public List<DeliveryModel> listAll() {
		return deliveryMapper.toCollectionModel(deliveryRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DeliveryModel> findById(@PathVariable Long id) {		
		return deliveryRepository.findById(id)
				.map(delivery -> ResponseEntity.ok(deliveryMapper.toModel(delivery)))
				.orElse(ResponseEntity.notFound().build());
	}
	
}
