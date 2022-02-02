package com.maikon.vendas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maikon.vendas.domain.entity.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

	@Query(value = " select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
	List<Cliente> encontrarPorNome(@Param("nome") String nome);

	@Query(" delete from Cliente c where c.nome =:nome ")
	@Modifying
	void deleteByNome(String nome);

//	List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

//	Cliente finfOneByNome(String nome, Integer id);

	boolean existsByNome(String nome);

	@Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id  ")
	Cliente findClienteFetchPedidos(@Param("id") Integer id);

}
