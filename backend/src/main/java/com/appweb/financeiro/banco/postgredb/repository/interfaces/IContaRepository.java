package com.appweb.financeiro.banco.postgredb.repository.interfaces;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appweb.financeiro.banco.postgredb.entity.Conta;

public interface IContaRepository extends JpaRepository<Conta, UUID> {

}
