package br.com.mercadinho.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.mercadinho.model.entidades.ItemVenda;
import br.com.mercadinho.model.util.JPAManager;

public class ItemVendaDaoImpl extends DAOImpl<ItemVenda> implements ItemVendaDao {

	private EntityManager manager = JPAManager.getInstance().getEntityManager();

	public ItemVendaDaoImpl() {
		super(ItemVenda.class);
	}

	public List<ItemVenda> listarPorQuantidade(String quantidade) {
		return manager.createQuery("SELECT i from ItemVenda i " + "where i.quantidade = :quantidade", ItemVenda.class)
				.setParameter("quantidade", quantidade).getResultList();
	}

	public List<ItemVenda> listarPorPreco(double preco) {
		return manager.createQuery("SELECT i FROM ItemVenda i " + "where i.preco = :preco", ItemVenda.class)
				.setParameter("preco", preco).getResultList();
	}

	public void excluir(ItemVenda i) {

		try {
			manager.getTransaction().begin();
			manager.remove(i);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

}
