package br.com.mercadinho.model.dao;

import java.util.List;

import br.com.mercadinho.model.entidades.Cliente;

public interface ClienteDao {

	public List<Cliente> listar();

	public Cliente buscarPorCpf(String cpf);

	public Cliente buscarPorNome(String nomeCliente);

}
