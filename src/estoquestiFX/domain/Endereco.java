package estoquestiFX.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@NamedQueries({
	@NamedQuery(name = "Endereco.listar", query = "SELECT endereco FROM Endereco endereco"),
	@NamedQuery(name = "Endereco.buscar", query = "SELECT endereco FROM Endereco endereco WHERE endereco.logradouro LIKE :logradouro")
})
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 60, nullable = false)
	@NotNull(message = "Digite um Logradouro")
	@NotEmpty(message = "Digite um Logradouro")
	@Length(min = 4, max = 60, message = "Digite um logradouro entre 4 e 60 caracteres")
	private String logradouro;
	
	@Column(length = 11, nullable = false)
	@NotNull(message = "Digite um Número")
	@Min(value = 1, message = "Digite um número válido")
	private int numero;
	
	@Column(length = 45, nullable = true)
	@Length(min = 2, max = 45, message = "Complemento muito grande")
	private String complemento;
	
	@Column(length = 45, nullable = false)
	@Length(min = 3, max = 45, message = "Digite um bairro entre 3 e 45 caracteres")
	private String bairro;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private Cidade cidade;
	
	@Column(length = 11, nullable = true)
	@Length(min = 8, max = 11, message = "Digite um cep Válido")
	private String cep;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
}
