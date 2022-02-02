package com.maikon.vendas.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maikon.vendas.domain.entity.Cliente;
import com.maikon.vendas.domain.repository.ClientesRepository;

@Controller // Passa a ser controlada pela camada de injeção controller do Spring.
public class ClienteController {

	private ClientesRepository clientes;

	public ClienteController(ClientesRepository clientes) {
		this.clientes = clientes;
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/api/clientes/{id}")
	@ResponseBody
	public ResponseEntity getClienteById(@PathVariable Integer id) {
		Optional<Cliente> cliente = clientes.findById(id);

		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}

		return ResponseEntity.notFound().build();
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/api/clientes")
	@ResponseBody
	public ResponseEntity save(@RequestBody Cliente cliente) {
		Cliente clienteSalvo = clientes.save(cliente);
		return ResponseEntity.ok(clienteSalvo);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/api/clientes/{id}")
	@ResponseBody
	public ResponseEntity delete(@PathVariable Integer id) {
		Optional<Cliente> cliente = clientes.findById(id);

		if (cliente.isPresent()) {
			clientes.delete(cliente.get());
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

	@SuppressWarnings("rawtypes")
	@PutMapping("/api/clientes/{id}")
	@ResponseBody
	public ResponseEntity update(@PathVariable Integer id, @RequestBody Cliente cliente) {
		return clientes.findById(id).map(clienteExistente -> {
			cliente.setId(clienteExistente.getId());
			clientes.save(cliente);
			return ResponseEntity.noContent().build();
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/api/clientes")
	public ResponseEntity find(Cliente filtro) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

		Example example = Example.of(filtro, matcher);
		List<Cliente> lista = clientes.findAll(example);
		return ResponseEntity.ok(lista);
	}

}
