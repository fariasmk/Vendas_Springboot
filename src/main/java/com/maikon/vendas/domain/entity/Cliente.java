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
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente") // Só é necessário se o nome da tabela for diferente do nome da classe.
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") // Só é necessário se o nome da coluna for diferente do nome id.
	private Integer id;

	@Column(name = "nome", length = 100) // Só é necessário se o nome da coluna for diferente do nome id.
	@NotEmpty(message = "{campo.nome.obrigatorio}") // Verifica se a propriedade está vazia
	private String nome;

	@Column(name = "cpf", length = 11)
	@NotEmpty(message = "{campo.cpf.obrigatorio}") //Verifica se a propriedade está vazia
	@CPF(message = "{campo.cpf.invalido}") //Verifica se o CPF é valido
	private String cpf;

	@JsonIgnore
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY) // Um Cliente para muitos pedidos.
	private Set<Pedido> pedidos;

	public Cliente(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

}
