package br.com.mercadinho.model.dao;

import br.com.mercadinho.model.entidades.Usuario;

public interface UsuarioDao {

	public Usuario buscarPorId(Integer id);

	public Usuario consultarPorLogin(String cpf);

	public Usuario autenticarUsuario(String cpf, String senha);

}
