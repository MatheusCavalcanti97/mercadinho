package br.com.mercadinho.model;

import java.util.List;

import br.com.mercadinho.model.dao.DespesasDaoImpl;
import br.com.mercadinho.model.entidades.Despesas;
import br.com.mercadinho.model.excecoes.VerificacaoNumeroRealException;
import br.com.mercadinho.model.excecoes.VerificacaoObjectNullException;
import br.com.mercadinho.model.util.MetodosVerificadores;

public class DespesasModel {

	private DespesasDaoImpl dao = new DespesasDaoImpl();
	private static DespesasModel despModel;

	public DespesasModel() {

	}

	public static final DespesasModel getInstance() {
		if (despModel == null) {
			despModel = new DespesasModel();
		}
		return despModel;
	}

	public void inserirDespesa(Despesas d) throws VerificacaoObjectNullException, VerificacaoNumeroRealException {
		if (d != null) {
			if (MetodosVerificadores.verificacaoNumeroReal(d.getValor())) {
				dao.inserir(d);
			} else {
				throw new VerificacaoNumeroRealException("Valor inválido!");
			}
		} else {
			throw new VerificacaoObjectNullException("Todos os campos devem estar preenchidos!");
		}
	}

	public void excluirDespesas(Despesas d) {
		dao.buscarPorId(d.getIdDespesa());
	}

	public void atualizarDespesas(Despesas d) throws VerificacaoObjectNullException, VerificacaoNumeroRealException {
		if (d != null) {
			if (MetodosVerificadores.verificacaoNumeroReal(d.getValor())) {
				dao.inserir(d);
			} else {
				throw new VerificacaoNumeroRealException("Valor inválido!");
			}
		} else {
			throw new VerificacaoObjectNullException("Todos os campos devem estar preenchidos!");
		}
	}

	public List<Despesas> listarTodos() {
		return dao.buscarTodos();
	}

	public Despesas buscarPorDescricao(String descricaoDespesa) {
		return dao.buscarPorDescricao(descricaoDespesa);
	}

}
