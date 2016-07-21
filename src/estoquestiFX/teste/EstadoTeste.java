package estoquestiFX.teste;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import Validator.Validar;
import estoquestiFX.bean.EstadoBean;
import estoquestiFX.dao.EstadoDAO;
import estoquestiFX.domain.Estado;

public class EstadoTeste {

	@Test
	public void novoEstado(){
		EstadoBean ebean = new EstadoBean();
		
		ebean.salvar("Minas Gerais");
	}
	
	@Test
	public void listar(){
		EstadoBean ebean = new EstadoBean();
		List<Estado> listaEstado = ebean.listar();
		
		for(Estado estado : listaEstado){
			System.out.println(estado.getId());
			System.out.println(estado.getNomeEstado());
		}
	}

}
