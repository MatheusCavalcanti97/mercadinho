package br.com.mercadinho.controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.mercadinho.controller.util.FacesUtil;
import br.com.mercadinho.model.FornecedorModel;
import br.com.mercadinho.model.entidades.Fornecedor;
import br.com.mercadinho.model.excecoes.VerificacaoCnpjException;
import br.com.mercadinho.model.excecoes.VerificacaoNomeException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectExistenteException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectNullException;
import br.com.mercadinho.model.excecoes.VerificacaoTelefoneException;

@RequestScoped
@ManagedBean(name = "fornecedorController")
public class FornecedorController {

	private Fornecedor fornecedor;
	List<Fornecedor> listaFornecedores;
	private FornecedorModel fom = FornecedorModel.getInstance();

	public FornecedorController() {
		this.fornecedor = new Fornecedor();
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FornecedorModel getFom() {
		return fom;
	}

	public void setFom(FornecedorModel fom) {
		this.fom = fom;
	}

	public List<Fornecedor> getListaFornecedores() {
		listaFornecedores = fom.listarTodos();
		return listaFornecedores;
	}

	public void setListaFornecedores(List<Fornecedor> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
	}

	public List<Fornecedor> buscarTodosFornecedores() {
		listaFornecedores = fom.listarTodos();
		return listaFornecedores;
	}

	public Fornecedor buscarPorCnpj(String cnpj) throws Exception {
		return fom.buscarPorCnpj(cnpj);
	}

	// ------------------------------------------------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------//

	public String inserirFornecedor() {

		try {
			fom.inserir(this.fornecedor);

			fornecedor = new Fornecedor();
			FacesUtil.addMsgInfo("Fornecedor cadastrado com sucesso!");

		} catch (VerificacaoCnpjException a) {
			FacesUtil.addMsgError(a.getMessage());
		} catch (VerificacaoNomeException b) {
			FacesUtil.addMsgError(b.getMessage());
		} catch (VerificacaoTelefoneException c) {
			FacesUtil.addMsgError(c.getMessage());
		} catch (VerificacaoObjectExistenteException d) {
			FacesUtil.addMsgError(d.getMessage());
		} catch (VerificacaoObjectNullException e) {
			FacesUtil.addMsgError(e.getMessage());
		}
		return "cadastroFornecedor.xhtml?faces-Redirect=true";
	}

	public void removerFornecedor(Fornecedor fo) {
		fom.excluir(fo);
		FacesUtil.addMsgInfo("Fornecedor excluido com sucesso!");
	}

	public void atualizarFornecedor() throws SQLException {

		try {
			fom.atualizar(this.fornecedor);

			fornecedor = new Fornecedor();
			FacesUtil.addMsgInfo("Fornecedor atualizado com sucesso!");
		} catch (VerificacaoCnpjException a) {
			FacesUtil.addMsgError(a.getMessage());
		} catch (VerificacaoNomeException b) {
			FacesUtil.addMsgError(b.getMessage());
		} catch (VerificacaoTelefoneException c) {
			FacesUtil.addMsgError(c.getMessage());
		} catch (VerificacaoObjectExistenteException d) {
			FacesUtil.addMsgError(d.getMessage());
		} catch (VerificacaoObjectNullException e) {
			FacesUtil.addMsgError(e.getMessage());
		}
	}
}
