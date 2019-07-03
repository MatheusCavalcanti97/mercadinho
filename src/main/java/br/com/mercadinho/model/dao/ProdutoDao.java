package br.com.mercadinho.model.dao;

import java.util.List;

import br.com.mercadinho.model.entidades.Produto;

public interface ProdutoDao {

	public List<Produto> listar();

	public Produto buscarPorNome(String nomeProduto);

	public Produto buscarPorMarca(String marcaProduto);

}
