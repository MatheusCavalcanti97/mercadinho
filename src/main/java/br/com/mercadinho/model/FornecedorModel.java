package br.com.mercadinho.model;

import java.util.List;

import br.com.mercadinho.model.dao.FornecedorDao;
import br.com.mercadinho.model.dao.FornecedorDaoImpl;
import br.com.mercadinho.model.entidades.Fornecedor;
import br.com.mercadinho.model.excecoes.VerificacaoCnpjException;
import br.com.mercadinho.model.excecoes.VerificacaoNomeException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectExistenteException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectNullException;
import br.com.mercadinho.model.excecoes.VerificacaoTelefoneException;
import br.com.mercadinho.model.util.MetodosVerificadores;

public class FornecedorModel {

	private FornecedorDaoImpl dao = new FornecedorDaoImpl();
	private static FornecedorModel fornModel;

	public FornecedorModel() {

	}

	public static final FornecedorModel getInstance() {
		if (fornModel == null) {
			fornModel = new FornecedorModel();
		}
		return fornModel;
	}

	public void inserir(Fornecedor fo) throws VerificacaoCnpjException, VerificacaoNomeException,
			VerificacaoTelefoneException, VerificacaoObjectExistenteException, VerificacaoObjectNullException {
		if (fo != null) {
			if (jaExiste(fo) == false) {
				if (MetodosVerificadores.verificacaoCnpj(fo.getCnpj())) {
					if (MetodosVerificadores.verificacaoNome(fo.getNomeFornecedor())) {
						if (MetodosVerificadores.verificacaoTelefone(fo.getTelefoneFornecedor())) {
							dao.inserir(fo);
						} else {
							// verif. Cnpj.
							throw new VerificacaoTelefoneException("Insira apenas numeros. Tam. Max: 14 Dígitos.");
						}
					} else {
						// Verif. Nome
						throw new VerificacaoNomeException(
								"Insira um Nome que contenha apenas Letras e não deixe campos em Branco.");
					}
				} else {
					// Verif. telefone
					throw new VerificacaoCnpjException("Insira um CNPJ válido.");
				}
			} else {
				throw new VerificacaoObjectExistenteException("Este Fornecedor já estar Cadastrado.");
			}
		} else {
			// Verif. Object Nulo
			throw new VerificacaoObjectNullException("Todos os campos devem estar preenchidos.");
		}

	}

	public void atualizar(Fornecedor fo) throws VerificacaoCnpjException, VerificacaoNomeException,
			VerificacaoTelefoneException, VerificacaoObjectExistenteException, VerificacaoObjectNullException {
		if (fo != null) {
			if (MetodosVerificadores.verificacaoCnpj(fo.getCnpj())) {
				if (MetodosVerificadores.verificacaoNome(fo.getNomeFornecedor())) {
					if (MetodosVerificadores.verificacaoTelefone(fo.getTelefoneFornecedor())) {
						dao.atualizar(fo);
					} else {
						// verif. Cnpj.
						throw new VerificacaoCnpjException("Insira um CNPJ válido.");
					}
				} else {
					// Verif. Nome
					throw new VerificacaoNomeException(
							"Insira um Nome que contenha apenas Letras e não deixe campos em Branco.");
				}
			} else {
				// Verf. Telefone.
				throw new VerificacaoTelefoneException("Insira apenas letrar e numeros. Tam. Max: 14 Dígitos.");
			}
		} else {
			// Verif. Object Nulo
			throw new VerificacaoObjectNullException("Todos os campos devem estar preenchidos.");
		}
	}

	public void excluir(Fornecedor fo) {
		dao.buscarPorId(fo.getIdFornecedor());
	}

	public boolean jaExiste(Fornecedor fo) {
		boolean existe = false;

		if (((FornecedorDao) dao).buscarPorCnpj(fo.getCnpj()) != null) {
			existe = true;
		}
		return existe;
	}

	public List<Fornecedor> listarTodos() {
		return dao.buscarTodos();
	}

	public Fornecedor buscarPorCnpj(String cnpj) {
		return dao.buscarPorCnpj(cnpj);
	}
}
