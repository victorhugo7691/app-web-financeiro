package com.appweb.financeiro.banco.postgredb.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.appweb.financeiro.banco.postgredb.enuns.ETipoDaTransacao;

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
@Table(name = "transacao")
public class Transacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false)
	private LocalDateTime dataEHora;

	@Column(nullable = false)
	private Float valor;

	@Column(nullable = false)
	private ETipoDaTransacao tipo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Conta conta;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getDataEHora() {
		return dataEHora;
	}

	public void setDataEHora(LocalDateTime dataEHora) {
		this.dataEHora = dataEHora;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public ETipoDaTransacao getTipo() {
		return tipo;
	}

	public void setTipo(ETipoDaTransacao tipo) {
		this.tipo = tipo;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
