package com.maikon.vendas.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente") //Só é necessário se o nome da tabela for diferente do nome da classe.
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id") //Só é necessário se o nome da coluna for diferente do nome id.
	private Integer id;
	
	@Column (name = "nome", length = 100) //Só é necessário se o nome da coluna for diferente do nome id.
	private String nome;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + "]";
	}

}
