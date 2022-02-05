package com.maikon.vendas.rest.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.maikon.vendas.validation.NotEmptyList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
	
	@NotNull(message = "{campo.codigo-cliente.obrigatorio}") //Garante que o campo não é nulo
    private Integer cliente;
	
	@NotNull(message = "{campo.total-pedido.obrigatorio}") //Garante que o campo não é nulo
    private BigDecimal total;
	
    @NotEmptyList(message = "{campo.items-pedido.obrigatorio}")
    private List<ItemPedidoDTO> itens;
}
