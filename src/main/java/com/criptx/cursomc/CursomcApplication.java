package com.criptx.cursomc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.criptx.cursomc"})
public class CursomcApplication implements CommandLineRunner {



    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    public void run(String... args) throws Exception {

    }
}
