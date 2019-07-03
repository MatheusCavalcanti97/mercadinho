package br.com.mercadinho.controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.mercadinho.controller.util.FacesUtil;
import br.com.mercadinho.model.ProdutoModel;
import br.com.mercadinho.model.entidades.Produto;
import br.com.mercadinho.model.excecoes.VerificacaoNomeException;
import br.com.mercadinho.model.excecoes.VerificacaoNumeroRealException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectExistenteException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectNullException;

@ManagedBean(name = "produtoController")
@ApplicationScoped
public class ProdutoController {

	private Produto produto;
	List<Produto> listaProdutos;
	private ProdutoModel pm = new ProdutoModel();

	public ProdutoController() {
		this.produto = new Produto();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoModel getPm() {
		return pm;
	}

	public void setPm(ProdutoModel pm) {
		this.pm = pm;
	}

	public List<Produto> getListaProdutos() {
		listaProdutos = pm.listarTodos();
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public List<Produto> buscarTodosProdutos() {
		listaProdutos = pm.listarTodos();
		return listaProdutos;
	}

	public Produto buscarPorNome(String nomeProduto) {
		return pm.buscarPorNome(nomeProduto);
	}

	public Produto buscarPorMarca(String marcaProduto) {
		return pm.buscarPorMarca(marcaProduto);
	}

	// ------------------------------------------------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------//

	public String inserirProduto() {

		try {
			pm.inserir(this.produto);

			produto = new Produto();
			FacesUtil.addMsgInfo("Produto cadastrado com sucesso!");

		} catch (VerificacaoNomeException a) {
			FacesUtil.addMsgError(a.getMessage());
		} catch (VerificacaoNumeroRealException b) {
			FacesUtil.addMsgError(b.getMessage());
		} catch (VerificacaoObjectNullException c) {
			FacesUtil.addMsgError(c.getMessage());
		} catch (VerificacaoObjectExistenteException d) {
			FacesUtil.addMsgError(d.getMessage());
		}
		return "cadastroProduto.xhtml?faces-Redirect=true";
	}

	public void removerProduto(Produto p) {
		pm.excluir(p);
		FacesUtil.addMsgInfo("Produto excluido com sucesso!");
	}

	public void atualizarProduto() throws SQLException {

		try {
			pm.atualizar(this.produto);

			produto = new Produto();
			FacesUtil.addMsgInfo("Produto atualizado com sucesso!");

		} catch (VerificacaoNomeException a) {
			FacesUtil.addMsgError(a.getMessage());
		} catch (VerificacaoNumeroRealException b) {
			FacesUtil.addMsgError(b.getMessage());
		} catch (VerificacaoObjectNullException c) {
			FacesUtil.addMsgError(c.getMessage());
		} catch (VerificacaoObjectExistenteException d) {
			FacesUtil.addMsgError(d.getMessage());
		}
	}
}
