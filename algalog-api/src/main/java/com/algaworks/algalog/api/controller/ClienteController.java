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

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
	
	private ClienteRepository clienteRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
    public Cliente createClient(@Valid @RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
	
	@GetMapping
	public List<Cliente> listAll() {		
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {		
		return clienteRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updateById(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(id);
		cliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
