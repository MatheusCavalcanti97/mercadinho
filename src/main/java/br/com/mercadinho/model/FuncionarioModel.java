package br.com.mercadinho.model;

import java.util.List;

import br.com.mercadinho.model.dao.FuncionarioDao;
import br.com.mercadinho.model.dao.FuncionarioDaoImpl;
import br.com.mercadinho.model.entidades.Funcionario;
import br.com.mercadinho.model.excecoes.VerificacaoCpfException;
import br.com.mercadinho.model.excecoes.VerificacaoEmailException;
import br.com.mercadinho.model.excecoes.VerificacaoNomeException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectExistenteException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectNullException;
import br.com.mercadinho.model.excecoes.VerificacaoTelefoneException;
import br.com.mercadinho.model.util.MetodosVerificadores;

public class FuncionarioModel {

	private FuncionarioDaoImpl dao = new FuncionarioDaoImpl();
	private static FuncionarioModel funModel;

	private FuncionarioModel() {

	}

	public static final FuncionarioModel getInstance() {
		if (funModel == null) {
			funModel = new FuncionarioModel();
		}
		return funModel;
	}

	public void inserir(Funcionario f)
			throws VerificacaoTelefoneException, VerificacaoEmailException, VerificacaoCpfException,
			VerificacaoObjectExistenteException, VerificacaoObjectNullException, VerificacaoNomeException {
		if (f != null) {
			if (jaExiste(f) == false) {
				if (MetodosVerificadores.verificacaoCpf(f.getCpfFuncionario())) {
					if (MetodosVerificadores.verificacaoNome(f.getNomeFuncionario())) {
						if (MetodosVerificadores.verificacaoEmail(f.getEmail())) {
							if (MetodosVerificadores.verificacaoTelefone(f.getTelefoneFuncionario())) {
								dao.inserir(f);
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
				throw new VerificacaoObjectExistenteException("Este Cliente já estar Cadastrado. (Via Cpf)");
			}

		} else {
			// Verif. Object Nulo
			throw new VerificacaoObjectNullException("Todos os campos devem estar preenchidos.");
		}
	}

	public void atualizar(Funcionario f)
			throws VerificacaoTelefoneException, VerificacaoEmailException, VerificacaoNomeException,
			VerificacaoCpfException, VerificacaoObjectNullException, VerificacaoObjectExistenteException {
		if (f != null) {
			if (MetodosVerificadores.verificacaoCpf(f.getCpfFuncionario())) {
				if (MetodosVerificadores.verificacaoNome(f.getNomeFuncionario())) {
					if (MetodosVerificadores.verificacaoEmail(f.getEmail())) {
						if (MetodosVerificadores.verificacaoTelefone(f.getTelefoneFuncionario())) {
							dao.atualizar(f);
						} else {
							// Verf. Telefone.
							throw new VerificacaoTelefoneException(
									"Insira apenas letrar e numeros. Tam. Max: 14 Dígitos.");
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
			throw new VerificacaoObjectNullException("Todos os campos devem estar preenchidos.");
		}
	}

	public void excluir(Funcionario f) {
		dao.buscarPorId(f.getIdFuncionario());
	}

	public boolean jaExiste(Funcionario f) {
		boolean existe = false;

		if (((FuncionarioDao) dao).buscarPorCpf(f.getCpfFuncionario()) != null) {
			existe = true;
		}
		return existe;
	}

	public List<Funcionario> listarTodos() {
		return dao.buscarTodos();
	}

	public Funcionario listarPorNome(String nomeFuncionario) {
		return dao.buscarPorNome(nomeFuncionario);
	}

	public Funcionario buscarPorCpf(String cpf) {
		return dao.buscarPorCpf(cpf);
	}

	public Funcionario buscarPorSalario(String nomeFuncionario) {
		return dao.buscarPorNome(nomeFuncionario);
	}

}