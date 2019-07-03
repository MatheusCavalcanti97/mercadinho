package br.com.mercadinho.model.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {


	private static final long serialVersionUID = 2020400989063156070L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;

	@Column(name = "nome_cliente")
	private String nomeCliente;

	@Column(name = "data_abertura")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAbertura;

	@Column(name = "cpf_cliente", nullable = false)
	private String cpf;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "telefone")
	private String telefone;

	@Embedded
	private Endereco endereco = new Endereco();

	@OneToMany(mappedBy = "cliente")
	private List<Venda> venda = new ArrayList<Venda>();

	public Cliente() {
		super();
	}

	public Cliente(Integer idCliente, String nomeCliente, Date dataAbertura, String cpf, String email, String telefone,
			Endereco endereco, List<Venda> venda) {
		super();
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.dataAbertura = dataAbertura;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.venda = venda;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		if (endereco == null) {
			endereco = new Endereco();
		}
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Venda> getVenda() {
		return venda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCliente;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataAbertura == null) ? 0 : dataAbertura.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((nomeCliente == null) ? 0 : nomeCliente.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}
	
	//

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (idCliente != other.idCliente)
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataAbertura == null) {
			if (other.dataAbertura != null)
				return false;
		} else if (!dataAbertura.equals(other.dataAbertura))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (nomeCliente == null) {
			if (other.nomeCliente != null)
				return false;
		} else if (!nomeCliente.equals(other.nomeCliente))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + idCliente + ", nome=" + nomeCliente + ", sobrenome=" + ", data_abertura="
				+ dataAbertura + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone + ", endereco="
				+ endereco + "]";
	}

}
