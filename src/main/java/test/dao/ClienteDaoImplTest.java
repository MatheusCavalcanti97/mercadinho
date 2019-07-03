package test.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.mercadinho.model.entidades.Cliente;
import br.com.mercadinho.model.util.JPAManager;

public class ClienteDaoImplTest extends DaoImplTest<Cliente> {

	private EntityManager manager = JPAManager.getInstance().getEntityManager();

	public ClienteDaoImplTest() {
		super(Cliente.class);
	}

	public List<Cliente> listar() {
		return manager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
	}

	public Cliente buscarPorCpf(String cpf) {
		return manager.createQuery("SELECT DISTINCT (c) from Cliente c where c.cpf = :cpf", Cliente.class)
				.setParameter("cpf", cpf).getSingleResult();
	}

	public Cliente buscarPorNome(String nomeCliente) {
		return manager.createQuery("SELECT DISTINCT (c) from Cliente c where c.nome = :nome", Cliente.class)
				.setParameter("nomeCliente", nomeCliente).getSingleResult();

	}

	public void excluir(Cliente c) {

		try {
			manager.getTransaction().begin();
			manager.remove(c);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

}
