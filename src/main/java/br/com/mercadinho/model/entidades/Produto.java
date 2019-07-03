package br.com.mercadinho.model.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable, Comparable<Produto> {

	private static final long serialVersionUID = 8938757211269408928L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Integer idProduto;

	@Column(name = "nome_produto")
	private String nomeProduto;

	@Column(name = "preco_produto")
	private double precoProduto;

	@Column(name = "quantidade_produto")
	private int quantidadeProduto;

	@Column(name = "tipo_produto")
	private String tipoProduto;

	@Column(name = "marca_produto")
	private String marcaProduto;

	@ManyToOne
	@JoinColumn(name = "id_fornecedor", referencedColumnName = "id_fornecedor")
	private Fornecedor fornecedor;

	public Produto() {

	}

	public Produto(Integer idProduto, String nomeProduto, double precoProduto, int quantidadeProduto,
			String tipoProduto, String marcaProduto, Fornecedor fornecedor) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.precoProduto = precoProduto;
		this.quantidadeProduto = quantidadeProduto;
		this.tipoProduto = tipoProduto;
		this.marcaProduto = marcaProduto;
		this.fornecedor = fornecedor;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	@Override
    public int compareTo(Produto produto) {
		if(this.fornecedor.getNomeFornecedor().compareTo(produto.fornecedor.getNomeFornecedor()) != 0){
			return this.fornecedor.getNomeFornecedor().compareTo(produto.fornecedor.getNomeFornecedor());
		}

        return 0;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProduto;
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + ((marcaProduto == null) ? 0 : marcaProduto.hashCode());
		result = prime * result + ((nomeProduto == null) ? 0 : nomeProduto.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precoProduto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantidadeProduto;
		result = prime * result + ((tipoProduto == null) ? 0 : tipoProduto.hashCode());
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
		Produto other = (Produto) obj;
		if (idProduto != other.idProduto)
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (marcaProduto == null) {
			if (other.marcaProduto != null)
				return false;
		} else if (!marcaProduto.equals(other.marcaProduto))
			return false;
		if (nomeProduto == null) {
			if (other.nomeProduto != null)
				return false;
		} else if (!nomeProduto.equals(other.nomeProduto))
			return false;
		if (Double.doubleToLongBits(precoProduto) != Double.doubleToLongBits(other.precoProduto))
			return false;
		if (quantidadeProduto != other.quantidadeProduto)
			return false;
		if (tipoProduto == null) {
			if (other.tipoProduto != null)
				return false;
		} else if (!tipoProduto.equals(other.tipoProduto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + idProduto + ", nome=" + nomeProduto + ", preco=" + precoProduto + ", quantidade="
				+ quantidadeProduto + ", tipo=" + tipoProduto + ", marca=" + marcaProduto + ", fornecedor=" + fornecedor
				+ "]";
	}

}
