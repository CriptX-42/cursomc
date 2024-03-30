package com.criptx.cursomc.repositories;

import com.criptx.cursomc.domain.Cliente;
import com.criptx.cursomc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
