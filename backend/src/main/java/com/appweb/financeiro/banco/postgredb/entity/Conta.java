package com.appweb.financeiro.banco.postgredb.entity;

import java.io.Serializable;
import java.util.UUID;

import com.appweb.financeiro.banco.postgredb.enuns.ESituacaoDaConta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false, unique = true, length = 6)
	private Integer numeroDaConta;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Cliente cliente;

	@Column(nullable = false)
	private ESituacaoDaConta situacao;

	@Column(nullable = false)
	private Float saldo;

	public Cliente getCliente() {
		return cliente;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(Integer numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ESituacaoDaConta getSituacao() {
		return situacao;
	}

	public void setSituacao(ESituacaoDaConta situacao) {
		this.situacao = situacao;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
