package com.maikon.vendas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maikon.vendas.domain.entity.Produto;

public interface ProdutosRepository extends JpaRepository<Produto, Integer> {

}
