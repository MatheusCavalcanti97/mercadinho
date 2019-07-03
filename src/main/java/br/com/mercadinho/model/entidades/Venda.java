package br.com.mercadinho.model.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "venda")
public class Venda implements Serializable {

	private static final long serialVersionUID = -5761321891996630000L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Venda", nullable = false)
	private Integer idVenda;

	@Column(name = "data_venda", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataVenda;

	@Column(name = "valor_total", nullable = false)
	private double valorTotal;

	@Column(name = "forma_pagamento", nullable = false, length = 45)
	private String formaPagamento;

	@Transient
	private List<ItemVenda> itensVenda;

	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Cliente cliente;

	public Venda() {

	}

	public Venda(Integer idVenda, Date dataVenda, double valorTotal, String formaPagamento, List<ItemVenda> itensVenda,
			Cliente cliente) {
		super();
		this.idVenda = idVenda;
		this.dataVenda = dataVenda;
		this.valorTotal = valorTotal;
		this.formaPagamento = formaPagamento;
		this.itensVenda = itensVenda;
		this.cliente = cliente;
	}

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + idVenda;
		result = prime * result + ((dataVenda == null) ? 0 : dataVenda.hashCode());
		result = prime * result + ((formaPagamento == null) ? 0 : formaPagamento.hashCode());
		result = prime * result + ((itensVenda == null) ? 0 : itensVenda.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (idVenda != other.idVenda)
			return false;
		if (dataVenda == null) {
			if (other.dataVenda != null)
				return false;
		} else if (!dataVenda.equals(other.dataVenda))
			return false;
		if (formaPagamento == null) {
			if (other.formaPagamento != null)
				return false;
		} else if (!formaPagamento.equals(other.formaPagamento))
			return false;
		if (idVenda == null) {
			if (other.idVenda != null)
				return false;
		} else if (!itensVenda.equals(other.itensVenda))
			return false;
		if (Double.doubleToLongBits(valorTotal) != Double.doubleToLongBits(other.valorTotal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venda [codigoItemID=" + idVenda + ", dataVenda=" + dataVenda + ", valorTotal=" + valorTotal
				+ ", formaPagamento=" + formaPagamento + ", itensvenda=" + itensVenda + ", cliente=" + cliente + "]";
	}

}
