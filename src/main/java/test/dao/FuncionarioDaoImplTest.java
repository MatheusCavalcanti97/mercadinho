package test.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.mercadinho.model.entidades.Funcionario;
import br.com.mercadinho.model.util.JPAManager;

public class FuncionarioDaoImplTest extends DaoImplTest<Funcionario>{
	
	public FuncionarioDaoImplTest(Class<Funcionario> f) {
		super(f);
		
	}

	private EntityManager manager = JPAManager.getInstance().getEntityManager();

	

	public List<Funcionario> listar() {
		return manager.createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList();
	}

	public Funcionario buscarPorCpf(String cpf) {
		return manager.createQuery("SELECT DISTINCT (f) from Funcionario f where f.cpfFuncionario = :cpf_funcionario", Funcionario.class)
				.setParameter("cpf_funcionario", cpf).getSingleResult();
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
