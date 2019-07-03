package br.com.mercadinho.controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.mercadinho.controller.util.FacesUtil;
import br.com.mercadinho.model.FuncionarioModel;
import br.com.mercadinho.model.entidades.Funcionario;
import br.com.mercadinho.model.excecoes.VerificacaoCpfException;
import br.com.mercadinho.model.excecoes.VerificacaoEmailException;
import br.com.mercadinho.model.excecoes.VerificacaoNomeException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectExistenteException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectNullException;
import br.com.mercadinho.model.excecoes.VerificacaoTelefoneException;

@RequestScoped
@ManagedBean(name = "funcionarioController")
public class FuncionarioController {

	private Funcionario funcionario;
	List<Funcionario> listaFuncionarios;
	private FuncionarioModel fm = FuncionarioModel.getInstance();
	String data;

	public FuncionarioController() {
		this.funcionario = new Funcionario();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public FuncionarioModel getFm() {
		return fm;
	}

	public void setFm(FuncionarioModel fm) {
		this.fm = fm;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Funcionario> getListaFuncionarios() {
		listaFuncionarios = fm.listarTodos();
		return listaFuncionarios;
	}

	public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

	public List<Funcionario> buscarTodosFuncionarios() {
		listaFuncionarios = fm.listarTodos();
		return listaFuncionarios;
	}

	public Funcionario buscarPorCpf(String cpf) throws Exception {
		return fm.buscarPorCpf(cpf);
	}

	public Funcionario buscarPorNome(String nomeFuncionario) {
		return fm.listarPorNome(nomeFuncionario);
	}

	public Funcionario buscarPorSalario(String nomeFuncionario) {
		return fm.buscarPorSalario(nomeFuncionario);
	}

	// ------------------------------------------------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------//

	public String inserirFuncionario() {

		try {
			fm.inserir(this.funcionario);

			funcionario = new Funcionario();
			FacesUtil.addMsgInfo("Funcionário cadastrado com sucesso.");

		} catch (VerificacaoTelefoneException a) {
			FacesUtil.addMsgError(a.getMessage());
		} catch (VerificacaoEmailException b) {
			FacesUtil.addMsgError(b.getMessage());
		} catch (VerificacaoCpfException c) {
			FacesUtil.addMsgError(c.getMessage());
		} catch (VerificacaoObjectNullException d) {
			FacesUtil.addMsgError(d.getMessage());
		} catch (VerificacaoObjectExistenteException e) {
			FacesUtil.addMsgError(e.getMessage());
		} catch (VerificacaoNomeException f) {
			FacesUtil.addMsgError(f.getMessage());
		}
		return "cadastroFuncionario.xhtml?faces-Redirect=true";
	}

	public void removerFuncionario(Funcionario f) {
		fm.excluir(f);
		FacesUtil.addMsgInfo("Funcionário Excluido.");
	}

	public void atualizarFuncionario() throws SQLException {
		try {
			fm.atualizar(this.funcionario);

			funcionario = new Funcionario();
			FacesUtil.addMsgInfo("Funcionário Atualizado com sucesso.");
		} catch (VerificacaoTelefoneException a) {
			FacesUtil.addMsgError(a.getMessage());
		} catch (VerificacaoEmailException b) {
			FacesUtil.addMsgError(b.getMessage());
		} catch (VerificacaoCpfException c) {
			FacesUtil.addMsgError(c.getMessage());
		} catch (VerificacaoObjectNullException d) {
			FacesUtil.addMsgError(d.getMessage());
		} catch (VerificacaoObjectExistenteException e) {
			FacesUtil.addMsgError(e.getMessage());
		} catch (VerificacaoNomeException f) {
			FacesUtil.addMsgError(f.getMessage());
		}

	}

	// ------------------------------------------------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------//
}
