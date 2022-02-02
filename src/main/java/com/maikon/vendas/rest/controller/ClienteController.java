package com.maikon.vendas.rest.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maikon.vendas.domain.entity.Cliente;
import com.maikon.vendas.domain.repository.ClientesRepository;

@Controller // Passa a ser controlada pela camada de injeção controller do Spring.
public class ClienteController {

	private ClientesRepository clientes;

	public ClienteController(ClientesRepository  clientes) {
		this.clientes = clientes;
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/api/clientes/{id}") //Obter Dados.
    @ResponseBody
    public ResponseEntity getClienteById( @PathVariable Integer id ){ //@PathVariable especifica que o id vai estar na url.
        Optional<Cliente> cliente = clientes.findById(id);

        if(cliente.isPresent()){
            return ResponseEntity.ok( cliente.get() ); // Retorna Status 200.
        }

        return ResponseEntity.notFound().build();
    }
}

