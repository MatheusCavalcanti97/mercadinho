package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.mercadinho.model.entidades.Endereco;
import br.com.mercadinho.model.entidades.Funcionario;
import br.com.mercadinho.model.util.JPAManager;

public class FuncionarioDaoTest {

	EntityManager manager = JPAManager.getInstance().getEntityManager();

	@Before
	public void antes() {
		manager.getTransaction().begin();
	}

	@Test
	public void Test1Salvar() {

		Funcionario f = new Funcionario();
		FuncionarioDaoImplTest cdit = new FuncionarioDaoImplTest(null);
		Endereco e = new Endereco();
		Date d = new Date();

		f.setNomeFuncionario("Cassete");
		f.setEmail("naoseidenada@hotmail.com kkkkk");
		f.setSalario(5000.00);
		f.setDataAdmissao(d);
		f.setTelefoneFuncionario("081999999999");
		f.setCpfFuncionario("11122233344");

		e.setUf("Pernambuco");
		e.setCidade("cidade");
		e.setBairro("bairro");
		e.setLogradouro("Casa");
		e.setNumeroImovel(10);
		e.setCep("11111000");

		f.setEndereco(e);

		manager.persist(f);
		manager.getTransaction().commit();

		Funcionario funcionarioBD = cdit.buscarPorCpf("1112223334466");
		assertEquals("12406186466", funcionarioBD.getCpfFuncionario());
	}

	@Test
	public void Test2Editar() {

		FuncionarioDaoImplTest funcionarioDaoTest = new FuncionarioDaoImplTest(null);
		Funcionario funcionario = funcionarioDaoTest.buscarPorCpf("11122233344");

		funcionario.setCpfFuncionario("09807040493");
		manager.merge(funcionario);
		manager.getTransaction().commit();

		Funcionario funcionarioEditado = funcionarioDaoTest.buscarPorCpf("09807040493");
		assertEquals("09807040493", funcionarioEditado.getCpfFuncionario());

	}

	@Test
	public void Test3Deletar() {
		FuncionarioDaoImplTest funcionarioDaoTest = new FuncionarioDaoImplTest(null);
		Funcionario funcionario = new Funcionario();

		funcionario.setCpfFuncionario("09807040493");
		;
		manager.persist(funcionario);

		manager.remove(funcionario);
		manager.getTransaction().commit();

		Funcionario funcExcluir = funcionarioDaoTest.buscarPorCpf("09807040493");
		assertNull(funcExcluir);

	}

	@Test
	public void Test4Listar() {
		FuncionarioDaoImplTest funcDaoTest = new FuncionarioDaoImplTest(null);
		List<Funcionario> funcLista = funcDaoTest.buscarTodos();
		assertEquals(1, funcLista.size());

	}

	@After
	public void depois() {
		// mng.getTransaction().rollback();
		manager.close();
	}
}
