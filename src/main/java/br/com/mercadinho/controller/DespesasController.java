package br.com.mercadinho.controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.mercadinho.controller.util.FacesUtil;
import br.com.mercadinho.model.DespesasModel;
import br.com.mercadinho.model.entidades.Despesas;
import br.com.mercadinho.model.excecoes.VerificacaoNumeroRealException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectNullException;

@RequestScoped
@ManagedBean(name = "despesasController")
public class DespesasController {

	private Despesas despesas;
	List<Despesas> listaDespesa;
	private DespesasModel dm = DespesasModel.getInstance();
	String data;

	public DespesasController() {
		this.despesas = new Despesas();
	}

	public Despesas getDespesas() {
		return despesas;
	}

	public void setDespesas(Despesas despesas) {
		this.despesas = despesas;
	}

	public DespesasModel getDm() {
		return dm;
	}

	public void setDm(DespesasModel dm) {
		this.dm = dm;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Despesas> ListarTodasDespesas() {
		listaDespesa = dm.listarTodos();
		return listaDespesa;
	}

	public void setListaDespesa(List<Despesas> listaDespesa) {
		this.listaDespesa = listaDespesa;
	}

	public Despesas buscarPorDescricao(String descricaoDespesa) {
		return dm.buscarPorDescricao(descricaoDespesa);
	}

	// ------------------------------------------------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------//

	public String inserirDespesas() {

		try {
			dm.inserirDespesa(this.despesas);
			FacesUtil.addMsgInfo("Despesa cadastrado com sucesso!");
		} catch (VerificacaoNumeroRealException a) {
			FacesUtil.addMsgError(a.getMessage());
		} catch (VerificacaoObjectNullException b) {
			FacesUtil.addMsgError(b.getMessage());
		}
		return "cadastroDespesas.xhtml?faces-Redirect=true";
	}

	public void removerDespesas(Despesas d) {
		dm.excluirDespesas(d);
		FacesUtil.addMsgInfo("Despesa excluida!");
	}

	public void atualizarDespesa() throws SQLException {

		try {
			dm.inserirDespesa(this.despesas);
			FacesUtil.addMsgInfo("Despesa atualizada com sucesso!");
		} catch (VerificacaoNumeroRealException a) {
			FacesUtil.addMsgError(a.getMessage());
		} catch (VerificacaoObjectNullException b) {
			FacesUtil.addMsgError(b.getMessage());
		}
	}
}
