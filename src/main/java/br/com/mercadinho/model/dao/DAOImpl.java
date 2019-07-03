package br.com.mercadinho.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.mercadinho.model.util.JPAManager;

public class DAOImpl<T> implements DAO<T> {

	private static EntityManager manager = JPAManager.getInstance().getEntityManager();

	private Class<T> classe;

	public DAOImpl(Class<T> classe) {
		this.classe = classe;
	}

	public void inserir(T obj) {
		manager = JPAManager.getInstance().getEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(obj);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public void atualizar(T obj) {
		manager = JPAManager.getInstance().getEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(obj);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public void excluir(T obj) {
		manager = JPAManager.getInstance().getEntityManager();
		try {
			manager.getTransaction().begin();
			manager.remove(obj);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public T buscarPorId(Integer id) {
		return manager.createQuery("SELECT DISTINCT (object) from " + classe.getName() + "object where object.id = :id",
				classe).setParameter("id", id).getSingleResult();
	}

	public List<T> buscarTodos() {
		List<T> lista = new ArrayList<T>();

		lista = manager.createQuery("SELECT * FROM" + classe.getName(), classe).getResultList();

		return lista;
	}
}