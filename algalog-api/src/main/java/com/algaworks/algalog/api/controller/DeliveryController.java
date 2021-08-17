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

import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;
import com.algaworks.algalog.domain.service.DeliveryRequestService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/deliveries")
public class DeliveryController {

	private DeliveryRepository deliveryRepository;
	private DeliveryRequestService deliveryRequestService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery request(@Valid @RequestBody Delivery delivery) {
		return deliveryRequestService.request(delivery);
	}
	
	@GetMapping
	public List<Delivery> listAll() {
		return deliveryRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Delivery> findById(@PathVariable Long id) {		
		return deliveryRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
}
