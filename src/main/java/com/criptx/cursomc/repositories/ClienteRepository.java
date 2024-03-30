package com.criptx.cursomc.repositories;

import com.criptx.cursomc.domain.Categoria;
import com.criptx.cursomc.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
