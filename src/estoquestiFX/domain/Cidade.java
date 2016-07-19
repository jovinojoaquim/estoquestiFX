package estoquestiFX.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@NamedQueries({
	@NamedQuery(name = "Cidade.listarCidadeEstado", query = "SELECT cidade FROM Cidade cidade"),
	@NamedQuery(name = "Cidade.buscarCidade", query = "SELECT cidade FROM Cidade cidade WHERE cidade.cidade LIKE :cidade"),
	@NamedQuery(name = "Cidade.buscarCidadeEEstado", query = "SELECT cidade FROM Cidade cidade WHERE cidade.cidade LIKE :cidade AND cidade.estado = :id_estado"),
	@NamedQuery(name = "Cidade.buscarPorEstado", query = "SELECT cidade FROM Cidade cidade WHERE cidade.estado = :id_estado")
})
public class Cidade {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 30)
	@Length(min = 3, max = 30, message = "Digite um cidade de 3 a 30 caracteres")
	@NotNull(message = "Digite uma Cidade")
	@NotEmpty(message = "O campo Cidade não pode ser em branco")
	private String cidade;
	
	@ManyToOne
	@JoinColumn(name = "estado_id", foreignKey = @ForeignKey(name = "estado_id_fk"))
	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
}
