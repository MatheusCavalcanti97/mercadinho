package br.com.mercadinho.model;

import java.util.List;

import br.com.mercadinho.model.dao.ClienteDao;
import br.com.mercadinho.model.dao.ClienteDaoImpl;
import br.com.mercadinho.model.entidades.Cliente;
import br.com.mercadinho.model.excecoes.VerificacaoCpfException;
import br.com.mercadinho.model.excecoes.VerificacaoEmailException;
import br.com.mercadinho.model.excecoes.VerificacaoNomeException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectExistenteException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectNullException;
import br.com.mercadinho.model.excecoes.VerificacaoTelefoneException;
import br.com.mercadinho.model.util.MetodosVerificadores;

public class ClienteModel {

	public ClienteDaoImpl dao = new ClienteDaoImpl();
	private static ClienteModel cliModel;

	private ClienteModel() {

	}

	public static final ClienteModel getInstance() {
		if (cliModel == null) {
			cliModel = new ClienteModel();
		}
		return cliModel;
	}

	public void inserir(Cliente c)
			throws VerificacaoTelefoneException, VerificacaoEmailException, VerificacaoCpfException,
			VerificacaoObjectExistenteException, VerificacaoObjectNullException, VerificacaoNomeException {
		if (c != null) {
			if (jaExiste(c) == false) {
				if (MetodosVerificadores.verificacaoCpf(c.getCpf())) {
					if (MetodosVerificadores.verificacaoNome(c.getNomeCliente())) {
						if (MetodosVerificadores.verificacaoEmail(c.getEmail())) {
							if (MetodosVerificadores.verificacaoTelefone(c.getTelefone())) {
								dao.inserir(c);
							} else {
								// Verf. Telefone.
								throw new VerificacaoTelefoneException("Insira apenas numeros. Tam. Max: 14 Dígitos.");
							}
						} else {
							// Verif. Email
							throw new VerificacaoEmailException("Insira um Email corretamente e Válido.");
						}
					} else {
						// Verif. Nome
						throw new VerificacaoNomeException(
								"Insira um Nome que contenha apenas Letras e não deixe campos em Branco.");
					}
				} else {
					// Verif. Cpf
					throw new VerificacaoCpfException("Insira um CPF válido.");
				}
			} else {
				// Verif. Object Nulo
				throw new VerificacaoObjectExistenteException("Cliente já cadastrado em Nosso Sistema. (Via Cpf)");
			}
		} else {
			throw new VerificacaoObjectNullException("Todos os campos devem estar preechidos.");
		}
	}

	public void atualizar(Cliente c) throws VerificacaoTelefoneException, VerificacaoEmailException, VerificacaoNomeException,
			VerificacaoCpfException, VerificacaoObjectNullException, VerificacaoObjectExistenteException {
		if (c != null) {
			if (jaExiste(c) == false) {
				if (MetodosVerificadores.verificacaoCpf(c.getCpf())) {
					if (MetodosVerificadores.verificacaoNome(c.getNomeCliente())) {
						if (MetodosVerificadores.verificacaoEmail(c.getEmail())) {
							if (MetodosVerificadores.verificacaoTelefone(c.getTelefone())) {
								dao.atualizar(c);
							} else {
								// Verf. Telefone.
								throw new VerificacaoTelefoneException(
										"Insira apenas letras e numeros. Tam. Max: 14 Dígitos.");
							}
						} else {
							// Verif. Email
							throw new VerificacaoEmailException("Insira um Email corretamente e Válido.");
						}
					} else {
						// Verif. Nome
						throw new VerificacaoNomeException(
								"Insira um Nome que contenha apenas Caracteres e não deixe campos em Branco.");
					}
				} else {
					// Verif. Cpf
					throw new VerificacaoCpfException("Insira um CPF válido.");
				}
			} else {
				// Verif. Object Nulo
				throw new VerificacaoObjectExistenteException("Cliente já cadastrado em Nosso Sistema. (Via Cpf)");
			}

		} else {
			throw new VerificacaoObjectNullException("Todos os campos devem estar preenchidos.");
		}
	}

	public void excluir(Cliente c) {
		dao.buscarPorId(c.getIdCliente());
	}

	public boolean jaExiste(Cliente c) {
		boolean existe = false;

		if (((ClienteDao) dao).buscarPorCpf(c.getCpf()) != null) {
			existe = true;
		}
		return existe;
	}

	public List<Cliente> listarTodos() {
		return dao.buscarTodos();
	}

	public Cliente listarPorNome(String nomeCliente) {
		return dao.buscarPorNome(nomeCliente);
	}

	public Cliente buscarPorCpf(String cpf) {
		return dao.buscarPorCpf(cpf);
	}
}