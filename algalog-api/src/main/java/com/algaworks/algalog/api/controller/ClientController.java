package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.mapper.ClientMapper;
import com.algaworks.algalog.api.model.ClientModel;
import com.algaworks.algalog.api.model.request.ClientRequest;
import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.repository.ClientRepository;
import com.algaworks.algalog.domain.service.ClientCatalogService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/clients")
public class ClientController {
	
	private ClientRepository clientRepository;
	private ClientCatalogService clientCatalogService;
	private ClientMapper clientMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
    public ClientModel createClient(@Valid @RequestBody ClientRequest clientRequest) {
		Client client = clientMapper.toEntity(clientRequest);
		Client createdClient = clientCatalogService.createClient(client);
		return clientMapper.toModel(createdClient);	
    }
	
	@GetMapping
	public List<ClientModel> listAll() {				
		return clientMapper.toCollectionModel(clientRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientModel> findById(@PathVariable Long id) {		
		return clientRepository.findById(id)
				.map(client -> ResponseEntity.ok(clientMapper.toModel(client)))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClientModel> updateById(@PathVariable Long id, @Valid @RequestBody ClientRequest clientRequest) {
		if (!clientRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		Client client = clientMapper.toEntity(clientRequest);
		client.setId(id);
		
		Client createdClient = clientCatalogService.createClient(client);
		
		return ResponseEntity.ok(clientMapper.toModel(createdClient));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		if (!clientRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		clientCatalogService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
