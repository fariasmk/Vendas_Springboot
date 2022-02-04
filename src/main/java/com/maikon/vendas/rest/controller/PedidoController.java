package com.maikon.vendas.rest.controller;

import static org.springframework.http.HttpStatus.*;


import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import com.maikon.vendas.domain.entity.ItemPedido;
import com.maikon.vendas.domain.entity.Pedido;
import com.maikon.vendas.domain.enuns.StatusPedido;
import com.maikon.vendas.rest.dto.AtualizacaoStatusPedidoDTO;
import com.maikon.vendas.rest.dto.InformacaoItemPedidoDTO;
import com.maikon.vendas.rest.dto.InformacoesPedidoDTO;
import com.maikon.vendas.rest.dto.PedidoDTO;
import com.maikon.vendas.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

	 private PedidoService service;

	    public PedidoController(PedidoService service) {
	        this.service = service;
	    }

	    @PostMapping
	    @ResponseStatus(CREATED)
	    public Integer save( @RequestBody PedidoDTO dto ){
	        Pedido pedido = service.salvar(dto);
	        return pedido.getId();
	    }

	    @GetMapping("{id}")
	    public InformacoesPedidoDTO getById( @PathVariable Integer id ){
	        return service
	                .obterPedidoCompleto(id)
	                .map( p -> converter(p) )
	                .orElseThrow(() ->
	                        new ResponseStatusException(NOT_FOUND, "Pedido não encontrado."));
	    }

	    @PatchMapping("{id}")
	    @ResponseStatus(NO_CONTENT)
	    public void updateStatus(@PathVariable Integer id ,
	                             @RequestBody AtualizacaoStatusPedidoDTO dto){
	        String novoStatus = dto.getNovoStatus();
	        service.atualizaStatus(id, StatusPedido.valueOf(novoStatus));
	    }

	    private InformacoesPedidoDTO converter(Pedido pedido){
	        return InformacoesPedidoDTO
	                .builder()
	                .codigo(pedido.getId())
	                .dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
	                .cpf(pedido.getCliente().getCpf())
	                .nomeCliente(pedido.getCliente().getNome())
	                .total(pedido.getTotal())
	                .status(pedido.getStatus().name())
	                .items(converter(pedido.getItens()))
	                .build();
	    }

	    private List<InformacaoItemPedidoDTO> converter(List<ItemPedido> itens){
	        if(CollectionUtils.isEmpty(itens)){
	            return Collections.emptyList();
	        }
	        return itens.stream().map(
	                item -> InformacaoItemPedidoDTO
	                            .builder().descricaoProduto(item.getProduto().getDescricao())
	                            .precoUnitario(item.getProduto().getPreco())
	                            .quantidade(item.getQuantidade())
	                            .build()
	        ).collect(Collectors.toList());
	    }
	}
