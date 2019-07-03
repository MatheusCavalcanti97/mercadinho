package br.com.mercadinho.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.mercadinho.model.entidades.Produto;
import br.com.mercadinho.model.util.JPAManager;

public class ProdutoDaoImpl extends DAOImpl<Produto> implements ProdutoDao {

	private EntityManager manager = JPAManager.getInstance().getEntityManager();

	public ProdutoDaoImpl() {
		super(Produto.class);
	}

	public List<Produto> listar() {
		return manager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
	}

	public Produto buscarPorNome(String nomeProduto) {
		return manager
				.createQuery("SELECT DISTINCT (p) from Produto p where p.nomeProduto = :nomeProduto", Produto.class)
				.setParameter("nomeProduto", nomeProduto).getSingleResult();
	}

	public Produto buscarPorMarca(String marcaProduto) {
		return manager
				.createQuery("SELECT DISTINCT (p) from Produto p where p.marcaProduto = :marcaProduto", Produto.class)
				.setParameter("nomeProduto", marcaProduto).getSingleResult();
	}

	public void excluir(Produto p) {

		try {
			manager.getTransaction().begin();
			manager.remove(p);
			manager.getTransaction().rollback();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

}
