package estoquestiFX.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column
	private boolean aprovacao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Fornecedor fornecedor;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PedidosProduto> pedidosProduto = new ArrayList<>();

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isAprovacao() {
		return aprovacao;
	}

	public void setAprovacao(boolean aprovacao) {
		this.aprovacao = aprovacao;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<PedidosProduto> getPedidosProduto() {
		return pedidosProduto;
	}

	public void setPedidosProduto(List<PedidosProduto> pedidosProduto) {
		this.pedidosProduto = pedidosProduto;
	}
	
	
	
}
