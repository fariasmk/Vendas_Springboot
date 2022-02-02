package com.maikon.vendas;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.maikon.vendas.domain.entity.Cliente;
import com.maikon.vendas.domain.entity.Pedido;
import com.maikon.vendas.domain.repository.ClientesRepository;
import com.maikon.vendas.domain.repository.PedidosRepository;

@SpringBootApplication
public class Vendas1Application {

	@Bean
	public CommandLineRunner init(@Autowired ClientesRepository clientes, @Autowired PedidosRepository pedidos) {
		return args -> {
			System.out.println("Salvando clientes");
			Cliente fulano = new Cliente("Fulano");
			clientes.save(fulano);

			Pedido p = new Pedido();
			p.setCliente(fulano);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));

			pedidos.save(p);

//            Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
//            System.out.println(cliente);
//            System.out.println(cliente.getPedidos());

			pedidos.findByCliente(fulano).forEach(System.out::println);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Vendas1Application.class, args);
	}
}