package br.com.mercadinho.model;

import java.util.List;

import br.com.mercadinho.model.dao.ProdutoDao;
import br.com.mercadinho.model.dao.ProdutoDaoImpl;
import br.com.mercadinho.model.entidades.Produto;
import br.com.mercadinho.model.excecoes.VerificacaoNomeException;
import br.com.mercadinho.model.excecoes.VerificacaoNumeroRealException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectExistenteException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectNullException;
import br.com.mercadinho.model.util.MetodosVerificadores;

public class ProdutoModel {

	private ProdutoDaoImpl dao = new ProdutoDaoImpl();
	private static ProdutoModel prodModel;

	public ProdutoModel() {

	}

	public static final ProdutoModel getInstance() {
		if (prodModel == null) {
			prodModel = new ProdutoModel();
		}
		return prodModel;
	}

	public void inserir(Produto p) throws VerificacaoNomeException, VerificacaoObjectExistenteException,
			VerificacaoObjectNullException, VerificacaoNumeroRealException {
		if (p != null) {
			if (jaExiste(p) == false) {
				if (MetodosVerificadores.verificacaoNome(p.getNomeProduto())) {
					if (MetodosVerificadores.verificacaoNumeroReal(p.getPrecoProduto())) {
						dao.inserir(p);
					} else {
						// Verif. Nome
						throw new VerificacaoNomeException(
								"Insira um Nome que contenha apenas Letras e não deixe em branco");
					}
				} else {
					// Verif. número real
					throw new VerificacaoNumeroRealException("Preço inválido.");
				}
			} else {
				// Verif. Object nulo
				throw new VerificacaoObjectNullException("Todos os campos devem estar preenchidos.");
			}
		} else {
			throw new VerificacaoObjectExistenteException("Este produto já estar Cadastrado.");
		}

	}

	public void atualizar(Produto p) throws VerificacaoNomeException, VerificacaoObjectExistenteException,
			VerificacaoObjectNullException, VerificacaoNumeroRealException {
		if (p != null) {
			if (MetodosVerificadores.verificacaoNome(p.getNomeProduto())) {
				if (MetodosVerificadores.verificacaoNumeroReal(p.getPrecoProduto())) {
					dao.atualizar(p);
				} else {
					// Verif. Nome
					throw new VerificacaoNomeException(
							"Insira um Nome que contenha apenas Letras e não deixe em branco");
				}
			} else {
				// Verif. número real
				throw new VerificacaoNumeroRealException("Insira apenas números reais.");
			}

		} else {
			// Verif. Object nulo
			throw new VerificacaoObjectNullException("Todos os campos devem estar preenchidos.");
		}

	}

	public void excluir(Produto p) {
		dao.buscarPorId(p.getIdProduto());
	}

	public boolean jaExiste(Produto p) {
		boolean existe = false;

		if (((ProdutoDao) dao).buscarPorNome(p.getNomeProduto()) != null) {
			existe = true;
		}
		return existe;
	}

	public List<Produto> listarTodos() {
		return dao.buscarTodos();
	}

	public Produto buscarPorNome(String nomeProduto) {
		return dao.buscarPorNome(nomeProduto);
	}

	public Produto buscarPorMarca(String marcaProduto) {
		return dao.buscarPorMarca(marcaProduto);
	}

}
