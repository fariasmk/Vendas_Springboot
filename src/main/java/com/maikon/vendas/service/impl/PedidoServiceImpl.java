package com.maikon.vendas.service.impl;

import org.springframework.stereotype.Service;

import com.maikon.vendas.domain.repository.PedidosRepository;
import com.maikon.vendas.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@SuppressWarnings("unused")
	private PedidosRepository repository;

	public PedidoServiceImpl(PedidosRepository repository) {
		this.repository = repository;
	}
}