package estoquestiFX.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PedidosProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedidosProduto;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private Produto produto;
	
	@Column(length = 100, precision = 7, scale = 2, nullable = false)
	private Double quantidade;
	
	@Column(length = 100, precision = 7, scale = 2, nullable = false)
	private Double precoCompra;

	public Long getIdPedidosProduto() {
		return idPedidosProduto;
	}

	public void setIdPedidosProduto(Long idPedidosProduto) {
		this.idPedidosProduto = idPedidosProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}
	
	
	
}
