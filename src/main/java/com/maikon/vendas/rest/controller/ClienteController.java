package com.maikon.vendas.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maikon.vendas.domain.entity.Cliente;

@Controller // Passa a ser controlada pela camada de injeção controller do Spring.
public class ClienteController {

	@RequestMapping(value = { "/api/clientes/hello/{nome}", "/api/hello" }, //Dessa forma podem ser acessadas ambas as urls.
					method = RequestMethod.POST, 							//Determina o método REST.
					consumes = { "application/json", "application/xml" },   //Define o tipo de conteúdo que o método pode receber. 
					produces = { "application/json", "application/xml" })	//Define o tipo de conteúdo que o método pode retornar.
	
	@ResponseBody
	public String helloCliente(@PathVariable("nome") String nomeCliente, @RequestBody Cliente cliente) {
		return String.format("Hello %s ", nomeCliente);
	}

}