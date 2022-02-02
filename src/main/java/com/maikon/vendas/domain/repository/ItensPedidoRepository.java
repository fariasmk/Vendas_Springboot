package com.maikon.vendas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maikon.vendas.domain.entity.ItemPedido;

public interface ItensPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
