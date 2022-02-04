package com.maikon.vendas.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.maikon.vendas.domain.enuns.StatusPedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Substitui getters, setters e demais métodos
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido") // Só é necessário se o nome da tabela for diferente do nome da classe.
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id") // Só é necessário se o nome da coluna for diferente do nome id.
	private Integer id;

	@ManyToOne // Muitos pedidos para um cliente..
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@Column(name = "data_pedido") // Só é necessário se o nome da coluna for diferente da variável.
	private LocalDate dataPedido;

	@Column(name = "total", precision = 20, scale = 2) // precision = 20 -> Qtde Caracteres / scale = 2 -> Casas
														// decimais
	private BigDecimal total;
	
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusPedido status;

	@OneToMany(mappedBy = "pedido") // Um pedido para muitos itens_pedido.
	private List<ItemPedido> itens;

}
