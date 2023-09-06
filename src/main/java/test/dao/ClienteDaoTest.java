package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.mercadinho.model.entidades.Cliente;
import br.com.mercadinho.model.entidades.Endereco;
import br.com.mercadinho.model.util.JPAManager;

public class ClienteDaoTest {

	EntityManager manager = JPAManager.getInstance().getEntityManager();

	@Before
	public void antes() {
		manager.getTransaction().begin();
	}

	@Test
	public void Test1Salvar() throws ParseException {

		Cliente c = new Cliente();
		ClienteDaoImplTest cdit = new ClienteDaoImplTest();
		Endereco e = new Endereco();

		Date d = new Date();

		c.setNomeCliente("joaozinho");
		c.setCpf("11122233344");
		c.setTelefone("081999999999");

		c.setDataAbertura(d);
		c.setEmail("joaozinho123@hotmail.com");

		e.setUf("SP");
		e.setCidade("Tamandagapio");
		e.setBairro("Centro");
		e.setLogradouro("Casa");
		e.setNumeroImovel(10);
		e.setCep("11222000");
		c.setEndereco(e);

		manager.persist(c);
		manager.getTransaction().commit();

		Cliente clienteBD = cdit.buscarPorCpf("11122233344");
		assertEquals("11122233344", clienteBD.getCpf());

	}

	@Test
	public void Test2Editar() {
		ClienteDaoImplTest clienteDaoTest = new ClienteDaoImplTest();
		Cliente cliente = clienteDaoTest.buscarPorCpf("09807040493");

		cliente.setCpf("09807040493");
		manager.merge(cliente);
		manager.getTransaction().commit();

		Cliente clienteEditado = clienteDaoTest.buscarPorCpf("09807040493");
		assertEquals("09807040493", clienteEditado.getCpf());
	}

	@Test
	public void Test3Deletar() {

		ClienteDaoImplTest clienteDaoTest = new ClienteDaoImplTest();
		Cliente cliente = new Cliente();

		cliente.setCpf("11040917470");
		manager.persist(cliente);

		manager.remove(cliente);
		manager.getTransaction().commit();

		Cliente clienteExcluir = clienteDaoTest.buscarPorCpf("09807040493");
		assertNull(clienteExcluir);
	}

	@Test
	public void Test4Listar() {
		ClienteDaoImplTest clienteDaoTest = new ClienteDaoImplTest();
		List<Cliente> clienteLista = clienteDaoTest.buscarTodos();
		assertEquals(1, clienteLista.size());

	}

	@After
	public void depois() {
		// mng.getTransaction().rollback();
		manager.close();
	}

}
