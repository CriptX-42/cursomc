package com.criptx.cursomc.repositories;

import com.criptx.cursomc.domain.ItemPedido;
import com.criptx.cursomc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
