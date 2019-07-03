package br.com.mercadinho.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.mercadinho.model.entidades.Endereco;
import br.com.mercadinho.model.util.JPAManager;

public class EnderecoDaoImpl extends DAOImpl<Endereco> implements EnderecoDao {

	private EntityManager manager = JPAManager.getInstance().getEntityManager();

	public EnderecoDaoImpl() {
		super(Endereco.class);
	}

	public List<Endereco> listar() {
		return manager.createQuery("SELECT e FROM Endereco d", Endereco.class).getResultList();
	}

}
