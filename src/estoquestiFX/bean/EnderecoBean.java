package estoquestiFX.bean;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import Validator.Validar;
import estoquestiFX.dao.EnderecoDAO;
import estoquestiFX.domain.Cidade;
import estoquestiFX.domain.Endereco;

public class EnderecoBean {

	public void salvar(String logradouro, String numero, String complemento, String bairro, String cep, 
			Cidade cidade) {
		Endereco e = new Endereco();
		EnderecoDAO dao = new EnderecoDAO();
		
		e.setLogradouro(logradouro);
		e.setNumero(Integer.parseInt(numero));
		e.setComplemento(complemento);
		e.setBairro(bairro);
		e.setCep(cep);
		e.setCidade(cidade);
		Set<ConstraintViolation<Endereco>> validacaoEndereco = Validar.getFabricaValidacao().validate(e);
		try{
			dao.salvar(e);
		}catch (RuntimeException e1) {
			throw new RuntimeException(validacaoEndereco.iterator().next().getMessage());
		}
	}

	public List<Endereco> listar() {
		EnderecoDAO dao = new EnderecoDAO();
		return dao.listar();
	}

	public List<Endereco> buscar(String logradouro) {
		EnderecoDAO dao = new EnderecoDAO();
		return dao.buscar(logradouro);
		
	}

}
