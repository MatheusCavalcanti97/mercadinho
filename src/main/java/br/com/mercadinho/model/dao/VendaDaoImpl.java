package br.com.mercadinho.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.mercadinho.model.entidades.Venda;
import br.com.mercadinho.model.util.JPAManager;

public class VendaDaoImpl extends DAOImpl<Venda> implements VendaDao {

	private EntityManager manager = JPAManager.getInstance().getEntityManager();

	public VendaDaoImpl() {
		super(Venda.class);
	}

	public List<Venda> listar() {
		return manager.createQuery("SELECT v FROM Venda v", Venda.class).getResultList();
	}

}
