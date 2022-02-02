package com.maikon.vendas.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id") //Só é necessário se o nome da coluna for diferente do nome id.
	private Integer id;
	
	@Column (name = "descricao") //Só é necessário se o nome da coluna for diferente da variável.
	private String descricao;
	
	@Column (name = "preco_unitario") //Só é necessário se o nome da coluna for diferente da variável
	private BigDecimal preco;

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
