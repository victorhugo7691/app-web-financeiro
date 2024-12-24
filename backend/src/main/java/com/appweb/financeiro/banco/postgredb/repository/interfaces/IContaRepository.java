package com.appweb.financeiro.banco.postgredb.repository.interfaces;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appweb.financeiro.banco.postgredb.entity.Conta;

public interface IContaRepository extends JpaRepository<Conta, UUID> {
	@Query(value = " SELECT * FROM conta "
			+ "		 WHERE cliente_id = :id", nativeQuery = true )
	public Conta findContaByClienteId(@Param("id") UUID id);
}
