package br.com.mercadinho.model.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "despesas")
public class Despesas implements Serializable {

	private static final long serialVersionUID = 3454294791928168152L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_despesa")
	private Integer idDespesa;

	@Column(name = "descricao_despesa")
	private String descricaoDespesa;

	@Column(name = "valor_despesa")
	private double valor;

	@Column(name = "data")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	public Despesas() {

	}

	public Despesas(Integer idDespesa, String descricaoDespesa, double valor, Date data) {
		super();
		this.idDespesa = idDespesa;
		this.descricaoDespesa = descricaoDespesa;
		this.valor = valor;
		this.data = data;
	}

	public Integer getIdDespesa() {
		return idDespesa;
	}

	public void setIdDespesa(Integer idDespesa) {
		this.idDespesa = idDespesa;
	}

	public String getDescricaoDespesa() {
		return descricaoDespesa;
	}

	public void setDescricaoDespesa(String descricaoDespesa) {
		this.descricaoDespesa = descricaoDespesa;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDespesa;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricaoDespesa == null) ? 0 : descricaoDespesa.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
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
		Despesas other = (Despesas) obj;
		if (idDespesa != other.idDespesa)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricaoDespesa == null) {
			if (other.descricaoDespesa != null)
				return false;
		} else if (!descricaoDespesa.equals(other.descricaoDespesa))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Despesas [codigo=" + idDespesa + ", descricao=" + descricaoDespesa + ", valor=" + valor + ", data="
				+ data + "]";
	}

}
