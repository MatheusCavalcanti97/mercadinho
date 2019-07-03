package br.com.mercadinho.controller;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import br.com.mercadinho.controller.util.FacesUtil;
import br.com.mercadinho.model.ClienteModel;
import br.com.mercadinho.model.entidades.Cliente;
import br.com.mercadinho.model.excecoes.VerificacaoCpfException;
import br.com.mercadinho.model.excecoes.VerificacaoEmailException;
import br.com.mercadinho.model.excecoes.VerificacaoNomeException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectExistenteException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectNullException;
import br.com.mercadinho.model.excecoes.VerificacaoTelefoneException;

@ManagedBean(name = "clienteController")
@RequestScoped
public class ClienteController {

	private Cliente cliente;
	private List<Cliente> listaClientes;
	private ClienteModel cm = ClienteModel.getInstance();
	String data;

	public ClienteController() {
		this.cliente = new Cliente();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteModel getCm() {
		return cm;
	}

	public void setCm(ClienteModel cm) {
		this.cm = cm;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Cliente> getListaClientes() {
		listaClientes = cm.listarTodos();
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<Cliente> buscarTodosClientes() {
		listaClientes = cm.listarTodos();
		return listaClientes;
	}

	public Cliente buscarPorCpf(String cpf) throws Exception {
		return cm.buscarPorCpf(cpf);
	}

	public Cliente buscarPorNome(String nomeFuncionario) {
		return cm.listarPorNome(nomeFuncionario);
	}

	// ------------------------------------------------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------//
	public String inserirCliente() {

		try {
			
			cm.inserir(this.cliente);

			cliente = new Cliente();
			FacesUtil.addMsgInfo("Cliente cadastrado com sucesso.");
			
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
		
	return "index.xhtml?faces-redirect=true";
		
	}

	public void removerCliente(Cliente c) {
		cm.excluir(c);
		FacesUtil.addMsgInfo("Cliente Excluido.");
	}

	public void AtualizarCliente() throws SQLException {
		try {
			cm.atualizar(this.cliente);
			
			FacesUtil.addMsgInfo("Cliente Atualizado com sucesso.");
		} catch (VerificacaoTelefoneException a) {
			FacesUtil.addMsgError(a.getMessage());
		} catch (VerificacaoEmailException b) {
			FacesUtil.addMsgError(b.getMessage());
		} catch (VerificacaoCpfException h) {
			FacesUtil.addMsgError(h.getMessage());
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
