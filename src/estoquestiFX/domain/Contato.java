package estoquestiFX.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
public class Contato {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idContato;
	
	@Column(length = 15, nullable = true)
	@Length(min = 15, max = 15, message = "Digite um telefone válido")
	private String telefoneComercial;
	
	@Column(length = 15, nullable = true)
	@Length(min = 15, max = 15, message = "Digite um celular válido")
	private String telefoneCelular;
	
	@Column(length = 45, nullable = true)
	@Email(message = "Digite um email válido")
	@Length(min = 10, max = 45, message = "Número de caracteres insuficiente")
	private String email;

	public Long getIdContato() {
		return idContato;
	}

	public void setIdContato(Long idContato) {
		this.idContato = idContato;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
