package br.com.mercadinho.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.mercadinho.model.entidades.Despesas;
import br.com.mercadinho.model.util.JPAManager;

public class DespesasDaoImpl extends DAOImpl<Despesas> implements DespesasDao {

	private EntityManager manager = JPAManager.getInstance().getEntityManager();

	public DespesasDaoImpl() {
		super(Despesas.class);
	}

	public List<Despesas> listar() {
		return manager.createQuery("SELECT d FROM Despesas d", Despesas.class).getResultList();
	}

	public Despesas buscarPorDescricao(String descricaoDespesa) {
		return manager.createQuery("SELECT DISTINCT (d) from Despesas d where d.descricaoDespesas = :descricaoDespesas",
				Despesas.class).setParameter("descricaoDespesas", descricaoDespesa).getSingleResult();
	}

	public void excluir(Despesas d) {

		try {
			manager.getTransaction().begin();
			manager.remove(d);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}
}
