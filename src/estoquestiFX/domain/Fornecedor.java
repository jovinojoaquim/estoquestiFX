package estoquestiFX.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFornecedor;
	
	@Column(length = 45, nullable = false)
	@NotEmpty(message = "Digite uma razão Social")
	@Length(min = 3, max = 45, message = "Número de caracteres inválido")
	private String razaoSocial;
	
	@Column(length = 45, nullable = false)
	@NotEmpty(message = "Digite um Nome Fantasia")
	@Length(min = 3, max = 45, message = "Números de caracteres inválido")
	private String nomeFantasia;
	
	@Column(length = 14, nullable = false)
	@NotEmpty(message = "Digite um CNPJ")
	@Length(min = 14, max = 14, message = "Número de caracteres inválido")
	private String cnpj;
	
	@Column(length = 40, nullable = false)
	@NotEmpty(message = "Digite uma Inscrição Estadual")
	@Length(min = 10, max = 40, message = "Número de caracteres inválido")
	private String inscricaoEstadual;
	
	@Column(length = 60, nullable = true)
	@Length(min = 3, max = 60, message = "Número de caracteres inválido")
	private String site;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_contato"))
	private List<Contato> contato;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(foreignKey = @ForeignKey(name="fk_endereco"))
	private List<Endereco> endereco;

	public Long getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public List<Contato> getContato() {
		return contato;
	}

	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
}
