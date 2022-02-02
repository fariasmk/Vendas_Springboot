package com.maikon.vendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.maikon.vendas.domain.entity.Cliente;
import com.maikon.vendas.domain.repository.ClientesRepository;

@SpringBootApplication
public class Vendas1Application {
	
    @Bean
    public CommandLineRunner commandLineRunner(@Autowired ClientesRepository clientes){
        return args -> {
            Cliente c = new Cliente(null, "Fulano");
            clientes.save(c);
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(Vendas1Application.class, args);
	}
}