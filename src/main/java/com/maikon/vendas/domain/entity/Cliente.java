package com.maikon.vendas.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cliente") // Só é necessário se o nome da tabela for diferente do nome da classe.
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id") // Só é necessário se o nome da coluna for diferente do nome id.
	private Integer id;

	@Column(name = "nome", length = 100) // Só é necessário se o nome da coluna for diferente do nome id.
	private String nome;

	@Column(name = "cpf", length = 11)
	private String cpf;

	@JsonIgnore
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY) // Um Cliente para muitos pedidos.
	private Set<Pedido> pedidos;

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Cliente(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + "]";
	}

}
