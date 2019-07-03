package br.com.mercadinho.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.mercadinho.model.entidades.Fornecedor;
import br.com.mercadinho.model.util.JPAManager;

public class FornecedorDaoImpl extends DAOImpl<Fornecedor> implements FornecedorDao {

	private EntityManager manager = JPAManager.getInstance().getEntityManager();

	public FornecedorDaoImpl() {
		super(Fornecedor.class);
	}

	public List<Fornecedor> listar() {
		return manager.createQuery("SELECT c FROM Cliente c", Fornecedor.class).getResultList();
	}

	public Fornecedor buscarPorCnpj(String cnpj) {
		return manager.createQuery("SELECT DISTINCT (fo) from Fornecedor fo where fo.cnpj = :cnpj", Fornecedor.class)
				.setParameter("cnpj", cnpj).getSingleResult();
	}

	public void excluir(Fornecedor fo) {

		try {
			manager.getTransaction().begin();
			manager.remove(fo);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

}
