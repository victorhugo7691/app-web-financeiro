package com.appweb.financeiro.banco.postgredb.enuns;

public enum ETipoDaTransacao {
	CREDITO(1, "Credito"), 
	DEBITO(2, "Debito");

	private final Integer id;

	private final String descricao;

	ETipoDaTransacao(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static ETipoDaTransacao fromId(int id) {
		for (ETipoDaTransacao situacao : ETipoDaTransacao.values()) {

			if (situacao.getId() == id) {
				return situacao;
			}
		}
		
		throw new IllegalArgumentException("Tipo de transação não encontrada!");
	}
}
