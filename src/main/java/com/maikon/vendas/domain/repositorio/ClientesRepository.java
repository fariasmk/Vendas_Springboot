package com.maikon.vendas.domain.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maikon.vendas.domain.entity.Cliente;

@Repository
public class ClientesRepository {

	@Autowired
	private EntityManager entityManager;

	@Transactional
	public Cliente salvar(Cliente cliente) {
		entityManager.persist(cliente);
		return cliente;
	}

	@Transactional
	public Cliente atualizar(Cliente cliente) {
		entityManager.merge(cliente);
		return cliente;
	}

	@Transactional
	public void deletar(Cliente cliente) {
		if (!entityManager.contains(cliente)) {
			cliente = entityManager.merge(cliente);
		}
		entityManager.remove(cliente);
	}

	@Transactional
	public void deletar(Integer id) {
		Cliente cliente = entityManager.find(Cliente.class, id);
		deletar(cliente);
	}

	@Transactional(readOnly = true)
	public List<Cliente> buscarPorNome(String nome) {
		String jpql = " select c from Cliente c where c.nome like :nome ";
		TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}

	@Transactional(readOnly = true)
	public List<Cliente> obterTodos() {
		return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
	}

}
