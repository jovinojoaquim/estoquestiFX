package estoquestiFX.bean;

import java.util.Set;

import javax.validation.ConstraintViolation;

import Validator.Validar;
import java.util.List;
import estoquestiFX.dao.EstadoDAO;
import estoquestiFX.domain.Estado;

public class EstadoBean {
	public void salvar(String nomeEstado){
		Estado estado = new Estado();
		EstadoDAO dao = new EstadoDAO();
		
		estado.setNomeEstado(nomeEstado);
		
		Set<ConstraintViolation<Estado>> validacao = Validar.getFabricaValidacao().validate(estado);
		try{
			dao.salvar(estado);
		}catch (RuntimeException e) {
			throw new RuntimeException(validacao.iterator().next().getMessage());
		}
	}
	
	public List<Estado> listar(){
		EstadoDAO dao = new EstadoDAO();
		return dao.listar();
	}
}
