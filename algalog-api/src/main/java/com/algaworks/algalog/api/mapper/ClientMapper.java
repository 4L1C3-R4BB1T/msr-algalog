package com.algaworks.algalog.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.ClientModel;
import com.algaworks.algalog.api.model.request.ClientRequest;
import com.algaworks.algalog.domain.model.Client;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ClientMapper {

	private ModelMapper modelMapper;
	
	public ClientModel toModel(Client client) {
		return modelMapper.map(client, ClientModel.class);
	}
	
	public List<ClientModel> toCollectionModel(List<Client> clients) {
		return clients.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Client toEntity(ClientRequest clientRequest) {
		return modelMapper.map(clientRequest, Client.class);
	}
	
}
