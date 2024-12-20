package com.appweb.financeiro.banco.postgredb.enuns;

public enum ESituacaoDaConta {

	ATIVA(1, "Ativo"),
	CANCELADA(2, "Cancelada"),
	BLOQUEADA(3, "Bloqueada");
	
	private final Integer id;
	
	private final String descricao;
	
	ESituacaoDaConta(int id, String descricao){
		this.id = id;
		this.descricao = descricao;
	}
	
	public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ESituacaoDaConta fromId(int id) {
        for (ESituacaoDaConta situacao : ESituacaoDaConta.values()) {
        	
            if (situacao.getId() == id) {
                return situacao;
            }
        }
        
        throw new IllegalArgumentException("Situação não encontrado para o id: " + id);
    }
}
