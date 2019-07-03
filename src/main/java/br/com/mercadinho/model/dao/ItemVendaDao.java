package br.com.mercadinho.model.dao;

import java.util.List;

import br.com.mercadinho.model.entidades.ItemVenda;

public interface ItemVendaDao {

	public List<ItemVenda> listarPorQuantidade(String quantidade);

	public List<ItemVenda> listarPorPreco(double preco);

}
