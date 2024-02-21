package com.criptx.cursomc;

import com.criptx.cursomc.domain.Categoria;
import com.criptx.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages={"com.criptx.cursomc"})
public class CursomcApplication implements CommandLineRunner {
	@Autowired
 	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null, "Informatica");
		Categoria categoria2 = new Categoria(null, "Escritório");

		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
	}
}
