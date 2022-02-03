package com.maikon.vendas.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maikon.vendas.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

	@SuppressWarnings("unused")
	private PedidoService service;

	public PedidoController(PedidoService service) {
		this.service = service;
	}
}
