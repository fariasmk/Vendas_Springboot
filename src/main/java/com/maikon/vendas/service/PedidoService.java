package com.maikon.vendas.service;

import java.util.Optional;

import com.maikon.vendas.domain.entity.Pedido;
import com.maikon.vendas.domain.enuns.StatusPedido;
import com.maikon.vendas.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto );
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
