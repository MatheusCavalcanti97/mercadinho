package br.com.mercadinho.model.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 806540229801021502L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFuncionario")
	private Integer idFuncionario;

	@Column(name = "nome_funcionario", nullable = false)
	private String nomeFuncionario;

	@Column(name = "cpf_funcionario", nullable = false)
	private String cpfFuncionario;

	@Column(name = "salario")
	private Double salario;

	@Column(name = "dataAdmissao")
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "telefoneFuncionario")
	private String telefoneFuncionario;

	@Embedded
	private Endereco endereco = new Endereco();

	public Funcionario() {
		super();
	}

	public Funcionario(Integer idFuncionario, String nomeFuncionario, String cpfFuncionario, Double salario,
			Date dataAdmissao, String email, String telefoneFuncionario, Endereco endereco) {
		super();
		this.idFuncionario = idFuncionario;
		this.nomeFuncionario = nomeFuncionario;
		this.cpfFuncionario = cpfFuncionario;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
		this.email = email;
		this.telefoneFuncionario = telefoneFuncionario;
		this.endereco = endereco;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getCpfFuncionario() {
		return cpfFuncionario;
	}

	public void setCpfFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefoneFuncionario() {
		return telefoneFuncionario;
	}

	public void setTelefoneFuncionario(String telefoneFuncionario) {
		this.telefoneFuncionario = telefoneFuncionario;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFuncionario;
		result = prime * result + ((dataAdmissao == null) ? 0 : dataAdmissao.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((nomeFuncionario == null) ? 0 : nomeFuncionario.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		result = prime * result + ((telefoneFuncionario == null) ? 0 : telefoneFuncionario.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (idFuncionario != other.idFuncionario)
			return false;
		if (dataAdmissao == null) {
			if (other.dataAdmissao != null)
				return false;
		} else if (!dataAdmissao.equals(other.dataAdmissao))
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
		if (nomeFuncionario == null) {
			if (other.nomeFuncionario != null)
				return false;
		} else if (!nomeFuncionario.equals(other.nomeFuncionario))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		if (telefoneFuncionario == null) {
			if (other.telefoneFuncionario != null)
				return false;
		} else if (!telefoneFuncionario.equals(other.telefoneFuncionario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [codigo=" + idFuncionario + ", nome=" + nomeFuncionario + ", salario=" + salario
				+ ", data_admissao=" + dataAdmissao + ", email=" + email + ", telefone=" + telefoneFuncionario
				+ ", endereco=" + endereco + "]";
	}

}
