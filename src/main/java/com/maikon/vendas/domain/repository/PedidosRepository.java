package com.maikon.vendas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maikon.vendas.domain.entity.Cliente;
import com.maikon.vendas.domain.entity.Pedido;

public interface PedidosRepository extends JpaRepository<Pedido, Integer> {
	
    List<Pedido> findByCliente(Cliente cliente);
}
