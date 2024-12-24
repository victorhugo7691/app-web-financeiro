package com.appweb.financeiro.banco.postgredb.repository.interfaces;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appweb.financeiro.banco.postgredb.entity.Transacao;

public interface ITransacaoRepository extends JpaRepository<Transacao, UUID> {
	
	@Query(value = " SELECT t.* FROM transacao t     "
			+ "		 	WHERE t.conta_id = :contaId "
			+ "		 ORDER BY t.dataehora DESC;      ", nativeQuery = true)
	public List<Transacao> findTransacoesByContaId(@Param("contaId") UUID contaId);
	
	@Query(value = " SELECT t.* FROM transacao t     "
			+ "		 	WHERE t.conta_id = :contaId "
			+ "		 ORDER BY t.dataehora DESC       "
			+ "		 LIMIT 5;                       ", nativeQuery = true)
	public List<Transacao> findMiniTransacoesByContaId(@Param("contaId") UUID contaId);

}
