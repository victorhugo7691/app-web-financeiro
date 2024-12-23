package com.appweb.financeiro.banco.postgredb.repository.interfaces;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appweb.financeiro.banco.postgredb.entity.SenhaDoUsuario;

public interface ISenhaDoUsuarioRepository extends JpaRepository<SenhaDoUsuario, UUID> {

	@Query(value = " SELECT s.*                                  "
			+ "		 FROM senha s                                "
			+ " 	 	INNER JOIN conta c ON s.conta_id =  c.id "
			+ "  	 WHERE c.numero_da_conta = :id               ", nativeQuery = true)
	public SenhaDoUsuario findSenhaByConta(@Param("id") Integer id);
}
