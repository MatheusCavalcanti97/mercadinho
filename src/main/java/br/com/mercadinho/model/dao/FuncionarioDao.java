package br.com.mercadinho.model.dao;

import java.util.List;

import br.com.mercadinho.model.entidades.Funcionario;

public interface FuncionarioDao {
	public List<Funcionario> listar();
	public Funcionario buscarPorCpf(String cpf);
	public Funcionario buscarPorNome(String nomeFuncionario);
	
}

