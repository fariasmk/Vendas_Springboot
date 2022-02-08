package com.maikon.vendas.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") // Só é necessário se o nome da coluna for diferente do nome id.
	private Integer id;
	
	@Column(name = "descricao") // Só é necessário se o nome da coluna for diferente da variável.
	@NotEmpty(message = "{campo.descricao.obrigatorio}") //Verifica se a propriedade está vazia
	private String descricao;

	@Column(name = "preco_unitario") // Só é necessário se o nome da coluna for diferente da variável
	@NotNull(message = "{campo.preco.obrigatorio}") // Garante que o preço não é nulo
	private BigDecimal preco;

}
