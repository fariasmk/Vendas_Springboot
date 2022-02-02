package com.maikon.vendas.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_pedido") // Só é necessário se o nome da tabela for diferente do nome da classe.
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id") // Só é necessário se o nome da coluna for diferente do nome id.
	private Integer id;

	@ManyToOne // Muitos itens_pedido para um pedido.
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	@ManyToOne // Muitos itens_pedido para um produto.
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@Column // Só é necessário se o nome da coluna for diferente da variável.
	private Integer Quantidade;

	public ItemPedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		Quantidade = quantidade;
	}

}
