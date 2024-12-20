package com.appweb.financeiro.banco.postgredb.repository.interfaces;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appweb.financeiro.banco.postgredb.entity.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, UUID> {

}
