package br.com.mercadinho.model.entidades;

import java.io.Serializable;
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
import javax.persistence.Transient;

@Entity
@Table(name = "itemVenda")
public class ItemVenda implements Serializable {

	private static final long serialVersionUID = 6541392945435551774L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private Integer idItem;

	@Column(name = "quantidade_Item")
	private int quantidadeItem;

	@Column(name = "preco_item", nullable = false)
	private Double preco;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_produto")
	private Produto produto;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_venda")
	private Venda idVendaItem;

	@Transient
	private List<Produto> listaProdutos;

	public ItemVenda() {

	}

	public ItemVenda(Integer idItem, int quantidadeItem, Double preco, Produto produto, Venda idVendaItem,
			List<Produto> listaProdutos) {
		super();
		this.idItem = idItem;
		this.quantidadeItem = quantidadeItem;
		this.preco = preco;
		this.produto = produto;
		this.idVendaItem = idVendaItem;
		this.listaProdutos = listaProdutos;
	}

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public int getQuantidadeItem() {
		return quantidadeItem;
	}

	public void setQuantidadeItem(int quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getIdVendaItem() {
		return idVendaItem;
	}

	public void setIdVendaItem(Venda idVendaItem) {
		this.idVendaItem = idVendaItem;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idItem == null) ? 0 : idItem.hashCode());
		result = prime * result + ((idVendaItem == null) ? 0 : idVendaItem.hashCode());
		result = prime * result + ((listaProdutos == null) ? 0 : listaProdutos.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + quantidadeItem;
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
		ItemVenda other = (ItemVenda) obj;
		if (idItem == null) {
			if (other.idItem != null)
				return false;
		} else if (!idItem.equals(other.idItem))
			return false;
		if (idVendaItem == null) {
			if (other.idVendaItem != null)
				return false;
		} else if (!idVendaItem.equals(other.idVendaItem))
			return false;
		if (listaProdutos == null) {
			if (other.listaProdutos != null)
				return false;
		} else if (!listaProdutos.equals(other.listaProdutos))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (quantidadeItem != other.quantidadeItem)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemVenda [idItem=" + idItem + ", quantidadeItem=" + quantidadeItem + ", preco=" + preco + ", produto="
				+ produto + ", idVendaItem=" + idVendaItem + ", listaProdutos=" + listaProdutos + "]";
	}

}
