package br.com.mercadinho.model.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Observable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class Fornecedor extends Observable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8531450410674753704L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fornecedor")
	private Integer idFornecedor;

	@Column(name = "nome_fornecedor", nullable = false)
	private String nomeFornecedor;

	@Column(name = "cnpj", nullable = false)
	private String cnpj;

	@Column(name = "telefone_fornecedor", nullable = false, length = 14)
	private String telefoneFornecedor;

	@Embedded
	private Endereco endereco = new Endereco();

	@OneToMany(mappedBy = "fornecedor")
	private List<Produto> listProdutos;

	public Fornecedor() {

	}

	public Fornecedor(Integer idFornecedor, String nomeFornecedor, String cnpj, String telefoneFornecedor,
			Endereco endereco, List<Produto> listProdutos) {
		super();
		this.idFornecedor = idFornecedor;
		this.nomeFornecedor = nomeFornecedor;
		this.cnpj = cnpj;
		this.telefoneFornecedor = telefoneFornecedor;
		this.endereco = endereco;
		this.listProdutos = listProdutos;
	}

	public Integer getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefoneFornecedor() {
		return telefoneFornecedor;
	}

	public void setTelefoneFornecedor(String telefoneFornecedor) {
		this.telefoneFornecedor = telefoneFornecedor;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Produto> getListProdutos() {
		return listProdutos;
	}

	public void setListProdutos(List<Produto> listProdutos) {
		this.listProdutos = listProdutos;
	
			this.setChanged();
			this.notifyObservers(listProdutos);
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + idFornecedor;
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((nomeFornecedor == null) ? 0 : nomeFornecedor.hashCode());
		result = prime * result + ((telefoneFornecedor == null) ? 0 : telefoneFornecedor.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (idFornecedor != other.idFornecedor)
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (nomeFornecedor == null) {
			if (other.nomeFornecedor != null)
				return false;
		} else if (!nomeFornecedor.equals(other.nomeFornecedor))
			return false;
		if (telefoneFornecedor == null) {
			if (other.telefoneFornecedor != null)
				return false;
		} else if (!telefoneFornecedor.equals(other.telefoneFornecedor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fornecedor [codigofornecedor=" + idFornecedor + ", nome=" + nomeFornecedor + ", cnpj=" + cnpj
				+ ", telefone=" + telefoneFornecedor + ", endereco=" + endereco + "]";
	}

}
