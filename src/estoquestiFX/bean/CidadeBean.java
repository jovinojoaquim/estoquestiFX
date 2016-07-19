package estoquestiFX.bean;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import Validator.Validar;
import estoquestiFX.dao.CidadeDAO;
import estoquestiFX.domain.Cidade;
import estoquestiFX.domain.Estado;

public class CidadeBean {
	public void salvar(String cidade, Estado estado){
		Cidade c = new Cidade();
		CidadeDAO dao = new CidadeDAO();
		
		c.setCidade(cidade);
		c.setEstado(estado);
		
		Set<ConstraintViolation<Cidade>> validacaoCidade = Validar.getFabricaValidacao().validate(c);

		try{
			dao.salvar(c);
		}catch (RuntimeException e) {
			throw new RuntimeException(validacaoCidade.iterator().next().getMessage());
		}
	}
	
	public List<Cidade> listar(){
		CidadeDAO dao = new CidadeDAO();
		return dao.listar();
	}

	public List<Cidade> buscarCidade(String cidade) {
		CidadeDAO dao = new CidadeDAO();
		return dao.buscarCidade(cidade);
	}

	public List<Cidade> buscarCidade(String cidade, Estado estado) {
		CidadeDAO dao = new CidadeDAO();
		return dao.buscarCidade(cidade, estado.getId());
	}

	public List<Cidade> buscarCidade(Long id) {
		CidadeDAO dao = new CidadeDAO();
		return dao.buscarCidade(id);
	}
}
