package com.maikon.vendas.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_pedido") // Só é necessário se o nome da tabela for diferente do nome da classe.
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
