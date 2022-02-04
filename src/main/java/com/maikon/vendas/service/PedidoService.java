package com.maikon.vendas.service;

import com.maikon.vendas.domain.entity.Pedido;
import com.maikon.vendas.rest.dto.PedidoDTO;

public interface PedidoService {
	Pedido salvar(PedidoDTO dto);
}
