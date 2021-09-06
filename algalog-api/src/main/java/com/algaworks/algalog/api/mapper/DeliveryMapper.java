package com.algaworks.algalog.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.DeliveryModel;
import com.algaworks.algalog.api.model.request.DeliveryRequest;
import com.algaworks.algalog.domain.model.Delivery;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DeliveryMapper {

	private ModelMapper modelMapper;
	
	public DeliveryModel toModel(Delivery delivery) {
		return modelMapper.map(delivery, DeliveryModel.class);
	}
	
	public List<DeliveryModel> toCollectionModel(List<Delivery> deliveries) {
		return deliveries.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Delivery toEntity(DeliveryRequest deliveryRequest) {
		return modelMapper.map(deliveryRequest, Delivery.class);
	}
	
}
