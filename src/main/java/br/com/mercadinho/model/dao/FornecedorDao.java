package br.com.mercadinho.model.dao;

import java.util.List;

import br.com.mercadinho.model.entidades.Fornecedor;

public interface FornecedorDao {

	public List<Fornecedor> listar();

	public Fornecedor buscarPorCnpj(String cnpj);

}
