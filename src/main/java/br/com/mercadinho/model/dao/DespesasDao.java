package br.com.mercadinho.model.dao;

import java.util.List;

import br.com.mercadinho.model.entidades.Despesas;

public interface DespesasDao {
	
	public List<Despesas> listar();
	
	public Despesas buscarPorDescricao(String descricaoDespesa);

}
