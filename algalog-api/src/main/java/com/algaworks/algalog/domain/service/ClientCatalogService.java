package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.exception.BusinessException;
import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClientCatalogService {

	private ClientRepository clientRepository;
	
	@Transactional
	public Client createClient(Client client) {
		boolean emailExists = clientRepository.findByEmail(client.getEmail())
				.stream()
				.anyMatch(clientExists -> !clientExists.equals(client));
		
		if (emailExists) {
			throw new BusinessException("Já existe um cliente cadastrado com este email.");
		}
		
        return clientRepository.save(client);
    }
	
	@Transactional
	public void deleteById(Long id) {
		clientRepository.deleteById(id);
	}
	
}

