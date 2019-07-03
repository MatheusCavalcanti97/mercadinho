package br.com.mercadinho.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.mercadinho.model.entidades.Funcionario;
import br.com.mercadinho.model.util.JPAManager;;

public class FuncionarioDaoImpl extends DAOImpl<Funcionario> implements FuncionarioDao {

	private EntityManager manager = JPAManager.getInstance().getEntityManager();

	public FuncionarioDaoImpl() {
		super(Funcionario.class);
	}

	public List<Funcionario> listar() {
		return manager.createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList();
	}

	public Funcionario buscarPorCpf(String cpf) {
		return manager.createQuery("SELECT DISTINCT (f) from Funcionario f where f.cpf = :cpf", Funcionario.class)
				.setParameter("cpf", cpf).getSingleResult();
	}

	public Funcionario buscarPorNome(String nomeFuncionario) {
		return manager.createQuery("SELECT DISTINCT (f) from Funcionario f where f.nomeFuncionario = :nomeFuncionario",
				Funcionario.class).setParameter("nomeFuncionario", nomeFuncionario).getSingleResult();
	}

	public void excluir(Funcionario f) {

		try {
			manager.getTransaction().begin();
			manager.remove(f);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

}
