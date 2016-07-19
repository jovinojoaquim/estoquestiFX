package estoquestiFX.teste;

import static org.junit.Assert.*;

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

//	private static Validator validator;
//	
//	@BeforeClass
//    public static void setUp() {
//       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//       validator = factory.getValidator();
//    }

	@Ignore
	public void test2() {
		Estado estado = new Estado();
		estado.setNomeEstado("asd");
		EstadoDAO dao = new EstadoDAO();
		
//		Validator validator = Validar.getFabricaValidacao().validate(estado);
		
//		Set<ConstraintViolation<Estado>> validacao = Validar.getFabricaValidacao().validate(estado);
		
//		try{
			dao.salvar(estado);
			
//		}catch (Exception e) {
//			System.out.println(validacao.iterator().next().getMessage());
//		}
		
	}
	
	@Ignore
	public void test() {
		Estado estado = new Estado();
		estado.setNomeEstado("asd");
		EstadoDAO dao = new EstadoDAO();
		
//		Validator validator = Validar.getFabricaValidacao();
//		
//		Set<ConstraintViolation<Estado>> validacao = validator.validate(estado);
		
		try{
			dao.salvar(estado);
			
		}catch (ConstraintViolationException e) {
			System.out.println(e.getCause());
		}
	}
	
	@Test
	public void teste3(){
		EstadoBean bean = new EstadoBean();
		bean.salvar("asd");
	}

}
